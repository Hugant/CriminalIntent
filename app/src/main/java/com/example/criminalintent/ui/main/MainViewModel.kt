package com.example.criminalintent.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.criminalintent.CriminalIntent

class MainViewModel : ViewModel() {
  val criminalIntent: MutableLiveData<CriminalIntent> by lazy {
    MutableLiveData<CriminalIntent>()
  }
}