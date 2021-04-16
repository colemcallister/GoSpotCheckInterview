package com.gospotcheck.android.gospotcheck.gscandroidinterview

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class StateCountCalculatorTest {

    private val subject = StateCountCalculator()

    @Test
    fun givenAListOfNationalParks_whenGetStateCountsIsCalled_thenTheCorrectCountsAreReturned() {

        val inputParks = listOf(
            NationalPark("A", "National Park & Preserve", "CA,AK,CO"),
            NationalPark("A", "National Park", "AK,CO"),
            NationalPark("A", null, "RI,AK"),
            NationalPark("A", null, "IL,IN,PA,ME"),
            NationalPark("A", null, "CO"),
            NationalPark("A", "National Park", "CO"),
            NationalPark("A", "National Park", "NV")
        )

        val output = subject.getStateCounts(inputParks)

        assertThat(output).containsAllIn(
            listOf(
                StateCount("CO", 4, 3),
                StateCount("AK", 3, 2),
                StateCount("CA", 1, 1),
                StateCount("RI", 1, 0),
                StateCount("IL", 1, 0),
                StateCount("IN", 1, 0),
                StateCount("PA", 1, 0),
                StateCount("ME", 1, 0),
                StateCount("NV", 1, 1)
            )
        )

    }
}