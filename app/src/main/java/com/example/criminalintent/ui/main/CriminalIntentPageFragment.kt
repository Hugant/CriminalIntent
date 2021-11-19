package com.example.criminalintent.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.criminalintent.CriminalIntent
import com.example.criminalintent.databinding.FragmentCriminalIntentPageBinding


class CriminalIntentPageFragment : Fragment() {
  companion object {
    @JvmStatic
    fun newInstance() = CriminalIntentPageFragment()
  }

  private lateinit var viewModel: MainViewModel
  private lateinit var binding: FragmentCriminalIntentPageBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentCriminalIntentPageBinding.inflate(inflater)
    return binding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    binding.bSendReport.setOnClickListener {
      viewModel.newCriminalIntent.value = CriminalIntent()
    }

  }
}