package com.gospotcheck.android.gospotcheck.gscandroidinterview


class StateCountCalculator {

    fun getStateCounts(nationalParks: List<NationalPark>): List<StateCount> {
        val mapOfNationalParkStateCountByState = mutableMapOf<String, StateCount>()

        nationalParks.forEach { nationalPark ->

            nationalPark.statesList().forEach { state ->
                val nationalParkStateCount = mapOfNationalParkStateCountByState[state] ?: StateCount(state, 0, 0)

                var newTotalCount = nationalParkStateCount.totalCount
                var newParkCount = nationalParkStateCount.parkCount

                newTotalCount++
                if (nationalPark.isNationalPark()) {
                    newParkCount++
                }

                mapOfNationalParkStateCountByState[state] = StateCount(state, newTotalCount, newParkCount)
            }
        }

        return mapOfNationalParkStateCountByState.values.toList().sortedByDescending { it.totalCount }
    }

}

data class StateCount(val state: String, val totalCount: Int, val parkCount: Int)