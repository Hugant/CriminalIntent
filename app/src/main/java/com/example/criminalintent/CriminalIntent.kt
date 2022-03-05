package com.example.criminalintent

import android.net.Uri
import java.util.*

data class CriminalIntent(
  val title: String, val imageUri: Uri, val rating: Float, val creationDate: Date, val isSolved: Boolean)