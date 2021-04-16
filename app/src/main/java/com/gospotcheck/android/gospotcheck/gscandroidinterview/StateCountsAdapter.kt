package com.gospotcheck.android.gospotcheck.gscandroidinterview

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StateCountsAdapter : RecyclerView.Adapter<CalculationViewHolder>() {

    private var stateCounts = emptyList<StateCount>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalculationViewHolder {
        return CalculationViewHolder(parent.inflate(R.layout.calculation_row_view))
    }

    override fun getItemCount() = stateCounts.size

    override fun onBindViewHolder(holder: CalculationViewHolder, position: Int) = holder.bind(
        stateCounts[position]
    )

    fun setStateCounts(stateCounts: List<StateCount>) {
        this.stateCounts = stateCounts
        notifyDataSetChanged()
    }
}

class CalculationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val stateTextView: TextView = itemView.findViewById(R.id.stateAbbreviationTextView)
    private val countTextView: TextView = itemView.findViewById(R.id.stateCountTextView)
    private val parkCountTextView: TextView = itemView.findViewById(R.id.stateParkCountTextView)

    @SuppressLint("SetTextI18n")
    fun bind(stateCount: StateCount) {
        stateTextView.text = stateCount.state
        val totalCount = stateCount.totalCount
        countTextView.text = totalCount.toString()
        val parkCount = stateCount.parkCount
        parkCountTextView.text = "(${stateCount.parkCount})"

        if (parkCount == totalCount) {
            parkCountTextView.visibility = View.GONE
        }
    }

}