package com.example.a20230310_carloscabrera_nycschools.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20230310_carloscabrera_nycschools.Rest.NYSchoolsRepository
import com.example.a20230310_carloscabrera_nycschools.model.SatResponse
import com.example.a20230310_carloscabrera_nycschools.model.SatResponseItem
import com.example.a20230310_carloscabrera_nycschools.model.SchoolResponse
import com.example.a20230310_carloscabrera_nycschools.model.SchoolResponseItem
import com.example.a20230310_carloscabrera_nycschools.tools.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NYSchoolViewModel @Inject constructor(
    private val nySchoolsRepository: NYSchoolsRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    var myDbn = ""
    var selectedSchool: SchoolResponseItem = SchoolResponseItem()

    var selectedSchoolSatInfo: SatResponseItem = SatResponseItem()


    private val _schoolList: MutableLiveData<ResponseState<List<SchoolResponseItem>>> =
        MutableLiveData(ResponseState.LOADING)
    val schoolList: LiveData<ResponseState<List<SchoolResponseItem>>> get() = _schoolList

    private val _satResult: MutableLiveData<ResponseState<List<SatResponseItem>>> =
        MutableLiveData(ResponseState.LOADING)
    val satResult: LiveData<ResponseState<List<SatResponseItem>>> get() = _satResult

    fun getSchoolList() {
        viewModelScope.launch(ioDispatcher) {
            nySchoolsRepository.getSchools().collect {
                _schoolList.postValue(it)
            }
        }
    }


    fun getSatResult(dbn: String? = null) {
        dbn?.let {
            viewModelScope.launch(ioDispatcher) {
                nySchoolsRepository.getSchoolSat(dbn).collect { item ->

                    _satResult.postValue(item)

                }
            }

        }
    }

}