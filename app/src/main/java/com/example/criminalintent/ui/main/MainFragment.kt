package com.example.criminalintent.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.criminalintent.CriminalIntent
import com.example.criminalintent.CriminalIntentAdapter
import com.example.criminalintent.R
import com.example.criminalintent.databinding.MainFragmentBinding
import java.util.*

class MainFragment : Fragment() {
  companion object {
    fun newInstance() = MainFragment()
  }

  private lateinit var viewModel: MainViewModel
  private lateinit var binding: MainFragmentBinding
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
    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    binding.apply {
      rcView.layoutManager = LinearLayoutManager(activity)
      rcView.adapter = adapter
      bAddIntent.setOnClickListener {
        requireActivity().supportFragmentManager.beginTransaction()
          .replace(R.id.container, CriminalIntentPageFragment.newInstance())
          .commitNow()
      }
    }
  }

}