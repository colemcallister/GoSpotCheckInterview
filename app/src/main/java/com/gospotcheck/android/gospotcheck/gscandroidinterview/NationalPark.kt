package com.gospotcheck.android.gospotcheck.gscandroidinterview


data class NationalPark(
    val fullName: String,
    val designation: String?,
    private val states: String
) {

    companion object {
        private const val NATIONAL_PARK = "National Park"
        private const val NATIONAL_PARK_PRESERVE = "National Park & Preserve"
    }

    // this has to be computed because GSON does not call constructor
    fun statesList() = states.split(",")

    fun isNationalPark() = designation == NATIONAL_PARK || designation == NATIONAL_PARK_PRESERVE
}