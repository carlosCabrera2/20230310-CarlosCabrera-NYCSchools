package com.example.a20230310_carloscabrera_nycschools.Rest

import com.example.a20230310_carloscabrera_nycschools.model.SatResponse
import com.example.a20230310_carloscabrera_nycschools.model.SatResponseItem
import com.example.a20230310_carloscabrera_nycschools.model.SchoolResponse
import com.example.a20230310_carloscabrera_nycschools.model.SchoolResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET(SCHOOL_iNFO)
    suspend fun getSchools(): Response<List<SchoolResponseItem>>

    @GET(SAT_INFO)
    suspend fun getSchoolSAT(
        @Query("dbn") dbn: String?
    ): Response<List<SatResponseItem>>

    companion object{
        //school info  //https://data.cityofnewyork.us/resource/s3k6-pzi2.json
        //school sat info https://data.cityofnewyork.us/resource/f9bf-2cp4.json?dbn=01M292

        const val BASE_URL = "https://data.cityofnewyork.us/resource/"
        const val SCHOOL_iNFO = "s3k6-pzi2.json"
        const val SAT_INFO= "f9bf-2cp4.json"


    }
}