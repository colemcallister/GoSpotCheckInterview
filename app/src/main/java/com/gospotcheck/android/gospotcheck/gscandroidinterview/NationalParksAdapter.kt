package com.gospotcheck.android.gospotcheck.gscandroidinterview

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NationalParksAdapter() : RecyclerView.Adapter<NationalParksViewHolder>() {

    private var nationalParks: List<NationalPark> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NationalParksViewHolder {
        val inflatedView = parent.inflate(R.layout.row_view)
        return NationalParksViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return nationalParks.size
    }

    override fun onBindViewHolder(holder: NationalParksViewHolder, position: Int) {
        holder.bind(nationalParks[position])
    }

    fun setNationalParks(nationalParks: List<NationalPark>) {
        this.nationalParks = nationalParks
        notifyDataSetChanged()
    }

    fun getNationalParks(): List<NationalPark> {
        return nationalParks
    }

}

class NationalParksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView: TextView = itemView.findViewById(R.id.parkNameTextView)
    private val designationTextView: TextView = itemView.findViewById(R.id.parkDesignationTextView)
    private val statesTextView: TextView = itemView.findViewById(R.id.statesTextView)

    fun bind(nationalPark: NationalPark) {
        nameTextView.text = nationalPark.fullName
        designationTextView.text = nationalPark.designation
        statesTextView.text = nationalPark.statesList().joinToString(", ")
    }

}