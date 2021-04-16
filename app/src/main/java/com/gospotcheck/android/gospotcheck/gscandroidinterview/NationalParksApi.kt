package com.gospotcheck.android.gospotcheck.gscandroidinterview

import com.gospotcheck.android.gospotcheck.gscandroidinterview.api.retrofit
import retrofit2.Call
import retrofit2.http.GET


import retrofit2.http.Query
import java.lang.Exception


class NationalParksApi {

    fun getParks(): NationalParksFetchResult {
        val parksRetrofit: NationalParksRetrofit = retrofit.create(NationalParksRetrofit::class.java)

        val call = parksRetrofit.getParks("National Park", 100)
        return try {

            val response = call.execute()
            NationalParksFetchResult(response.body()?.data, null)
        } catch (e: Exception) {
            NationalParksFetchResult(null, e)
        }
    }

}

interface NationalParksRetrofit {
    /**
     * See [NationalParksRetrofit] for base url and other Retrofit setup
     * call to {baseUrl}/parks?q="{search}"&limit={limit}
     */
    @GET("parks")
    fun getParks(@Query("q") search: String, @Query("limit") limit: Int): Call<NationalParksResponseBody>
}

data class NationalParksResponseBody(val data: List<NationalPark>)

