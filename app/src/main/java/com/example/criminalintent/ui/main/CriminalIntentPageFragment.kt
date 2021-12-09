package com.example.criminalintent.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.criminalintent.CriminalIntent
import com.example.criminalintent.databinding.FragmentCriminalIntentPageBinding
import java.util.*


class CriminalIntentPageFragment : Fragment() {
  companion object {
    @JvmStatic
    fun newInstance() = CriminalIntentPageFragment()
  }

  private lateinit var binding: FragmentCriminalIntentPageBinding
  private val viewModel: MainViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentCriminalIntentPageBinding.inflate(inflater)
    return binding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    binding.bSendReport.setOnClickListener {
      val date = Date()
      date.time = binding.calendarView.date

      viewModel.newCriminalIntent.value = CriminalIntent(
        binding.etTitle.text.toString(),
        binding.bChooseImage.id,
        binding.rbRating.numStars,
        date,
        binding.sSolved.isChecked
      )

      Log.i("My Tag", "Button clicked")
      requireActivity().supportFragmentManager.popBackStack()
    }

  }
}