package com.example.criminalintent.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.criminalintent.CriminalIntent

class MainViewModel : ViewModel() {
  val newCriminalIntent: MutableLiveData<CriminalIntent> by lazy {
    MutableLiveData<CriminalIntent>()
  }

  val editCriminalIntent: MutableLiveData<CriminalIntent> by lazy {
    MutableLiveData<CriminalIntent>()
  }
}