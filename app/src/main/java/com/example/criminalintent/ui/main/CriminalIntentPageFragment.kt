package com.example.criminalintent.ui.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
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
    const val REQUEST_CODE = 100
  }

  private lateinit var binding: FragmentCriminalIntentPageBinding
  private val viewModel: MainViewModel by activityViewModels()

  private var imageUri: Uri? = null

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentCriminalIntentPageBinding.inflate(inflater)
    return binding.root
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == Activity.RESULT_OK && data != null) {
      if (requestCode == REQUEST_CODE) {
        imageUri = data.data
        binding.ivImage.setImageURI(imageUri)
      }
    }
    super.onActivityResult(requestCode, resultCode, data)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    binding.bChooseImage.setOnClickListener {
      val intent = Intent(Intent.ACTION_GET_CONTENT)
      intent.type = "image/*"
      startActivityForResult(intent, REQUEST_CODE)
    }

    binding.bSendReport.setOnClickListener {
      if (binding.etTitle.length() < 3) {
        if (binding.etTitle.length() == 0) {
          Toast.makeText(context, "Please fill title", Toast.LENGTH_SHORT).show()
        } else {
          Toast.makeText(context, "Title should be gather then 2 letters", Toast.LENGTH_SHORT).show()
        }
      } else if (imageUri == null) {
        Toast.makeText(context, "You should choose an image", Toast.LENGTH_SHORT).show()
      } else {
        viewModel.newCriminalIntent.value = CriminalIntent(
          binding.etTitle.text.toString(),
          imageUri!!,
          binding.rbRating.rating,
          Date(binding.calendarView.date),
          binding.sSolved.isChecked
        )

        requireActivity().supportFragmentManager.popBackStack()
      }

    }

  }
}