package com.example.criminalintent

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.databinding.CriminalIntentItemBinding
import java.util.*

class CriminalIntentAdapter: RecyclerView.Adapter<CriminalIntentAdapter.CriminalIntentHolder>() {
  private val criminalIntents = ArrayList<CriminalIntent>()

  class CriminalIntentHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val binding = CriminalIntentItemBinding.bind(item)
    fun bind(criminalIntent: CriminalIntent) = with(binding){
      tvTitle.text = criminalIntent.title
      tvDate.text = criminalIntent.creationDate.toString()
      if (criminalIntent.isSolved) {
        ivSolved.visibility = View.VISIBLE
      } else {
        ivSolved.visibility = View.INVISIBLE
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriminalIntentHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.criminal_intent_item, parent, false)
    return CriminalIntentHolder(view)
  }

  override fun onBindViewHolder(holder: CriminalIntentHolder, position: Int) {
    holder.bind(criminalIntents[position])
  }

  override fun getItemCount(): Int {
    return criminalIntents.size
  }

  @SuppressLint("NotifyDataSetChanged")
  fun addItem(criminalIntent: CriminalIntent) {
    criminalIntents.add(criminalIntent)
    notifyDataSetChanged()
  }
}