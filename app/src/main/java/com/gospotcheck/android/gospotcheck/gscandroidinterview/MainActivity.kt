package com.gospotcheck.android.gospotcheck.gscandroidinterview

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val nationalParksAdapter = NationalParksAdapter()
    private val stateCountsAdapter = StateCountsAdapter()
    private val fetcher: NationalParksFetcher = InMemoryNationalParksFetcher()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        itemsRecyclerView.adapter = nationalParksAdapter

        swipeRefreshLayout.setOnRefreshListener {
            fetcher.getNationalParks { parks ->
                swipeRefreshLayout.isRefreshing = false
                parks.items?.let { items ->
                    nationalParksAdapter.setNationalParks(items)
                }

                if (parks.error != null || parks.items == null) {
                    showToast("Error fetching National Parks")
                }
            }
        }

        bottomSheetFAB?.setOnClickListener { fabClicked() }

        calculationsRecyclerView.adapter = stateCountsAdapter

    }

    private fun showToast(text: String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
    }

    private fun fabClicked() {
        val stateCounts = StateCountCalculator().getStateCounts(nationalParksAdapter.getNationalParks())
        stateCountsAdapter.setStateCounts(stateCounts)
        BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
    }
}
