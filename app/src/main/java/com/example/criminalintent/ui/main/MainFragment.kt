package com.example.criminalintent.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.criminalintent.CriminalIntent
import com.example.criminalintent.CriminalIntentAdapter
import com.example.criminalintent.R
import com.example.criminalintent.databinding.MainFragmentBinding
import java.util.*

class MainFragment : Fragment() {
  companion object {
    fun newInstance() = MainFragment()
    const val FRAGMENT_STACK = "FRAGMENT_STACK"
  }

  private lateinit var binding: MainFragmentBinding
  private val viewModel: MainViewModel by activityViewModels()
  private val adapter = CriminalIntentAdapter()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = MainFragmentBinding.inflate(inflater)
    return binding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    binding.apply {
      rcView.layoutManager = LinearLayoutManager(activity)
      rcView.adapter = adapter
      bAddIntent.setOnClickListener {
        requireActivity().supportFragmentManager.beginTransaction()
          .replace(R.id.container, CriminalIntentPageFragment.newInstance())
          .addToBackStack(FRAGMENT_STACK)
          .commit()
      }
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel.newCriminalIntent.observe(activity as LifecycleOwner, {
      it?.let {
        adapter.addItem(it)
      }
    })
  }
}