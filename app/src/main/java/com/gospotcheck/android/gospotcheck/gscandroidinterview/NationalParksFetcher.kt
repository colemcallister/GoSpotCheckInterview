package com.gospotcheck.android.gospotcheck.gscandroidinterview

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main


data class NationalParksFetchResult(val items: List<NationalPark>?, val error: Exception?)

interface NationalParksFetcher {
    fun getNationalParks(): NationalParksFetchResult
    fun getNationalParks(callback: (NationalParksFetchResult) -> Unit)
}

class InMemoryNationalParksFetcher : NationalParksFetcher {

    private val nationalParksApi: NationalParksApi = NationalParksApi()

    override fun getNationalParks(): NationalParksFetchResult {
        val list = listOf(
            NationalPark("Yosemite", "National Park", "CA"),
            NationalPark("Yellowstone", "National Park", "WY,MT,ID"),
            NationalPark("Atlantis", null, "CA"),
            NationalPark("Rocky Mountain", "National Park", "CO"),
            NationalPark("Black Canyon of the Gunnison", "National Park", "CO"),
            NationalPark("Great Sand Dunes", "National Park", "CO"),
            NationalPark("King's Canyon", "Forest", "CA"),
            NationalPark("Death Valley", null, "CA,NV")
        )
        return NationalParksFetchResult(list, null)
    }

    override fun getNationalParks(callback: (NationalParksFetchResult) -> Unit) {
        CoroutineScope(IO).launch {

            val parks = nationalParksApi.getParks()

            CoroutineScope(Main).launch {
                callback(parks)
            }
        }
    }
}
