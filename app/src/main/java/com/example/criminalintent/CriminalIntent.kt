package com.example.criminalintent

import java.util.*

data class CriminalIntent(
  val title: String, val imageId: Int, val rating: Int, val creationDate: Date, val isSolved: Boolean)