package com.example.a20230310_carloscabrera_nycschools.Rest

import com.example.a20230310_carloscabrera_nycschools.model.SatResponse
import com.example.a20230310_carloscabrera_nycschools.model.SatResponseItem
import com.example.a20230310_carloscabrera_nycschools.model.SchoolResponse
import com.example.a20230310_carloscabrera_nycschools.model.SchoolResponseItem
import com.example.a20230310_carloscabrera_nycschools.tools.FailureResponseException
import com.example.a20230310_carloscabrera_nycschools.tools.NullSatException
import com.example.a20230310_carloscabrera_nycschools.tools.NullSchoolException
import com.example.a20230310_carloscabrera_nycschools.tools.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


import javax.inject.Inject

interface NYSchoolsRepository {
    fun getSchools(): Flow<ResponseState<List<SchoolResponseItem>>>
    fun getSchoolSat(dbn: String): Flow<ResponseState<List<SatResponseItem>>>

}




class NYSchoolsRepositoryImp @Inject constructor(
    private val serviceApi: ServiceApi
):NYSchoolsRepository{
    override fun getSchools(): Flow<ResponseState<List<SchoolResponseItem>>> = flow{
        emit(ResponseState.LOADING)
        try {
            val response = serviceApi.getSchools()
            if (response.isSuccessful){
                response.body()?.let {
                    emit(ResponseState.SUCCESS(it))
                }?: throw NullSchoolException()

            }else{throw FailureResponseException(response.errorBody()?.string())}
        }catch (e: Exception){
            emit(ResponseState.ERROR(e))
        }
    }

    override fun getSchoolSat(dbn: String): Flow<ResponseState<List<SatResponseItem>>> = flow{
        emit(ResponseState.LOADING)
        try {
            val response = serviceApi.getSchoolSAT(dbn)
            if (response.isSuccessful){
                response.body()?.let {
                    emit(ResponseState.SUCCESS(it))
                }?: throw NullSatException()
            }else throw FailureResponseException(response.errorBody()?.string())
    }catch (e: Exception){
            emit(ResponseState.ERROR(e))
        }
    }

}



