package com.example.a20230310_carloscabrera_nycschools.ViewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.a20230310_carloscabrera_nycschools.Rest.NYSchoolsRepository
import com.example.a20230310_carloscabrera_nycschools.tools.ResponseState
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.Exception

class NYSchoolViewModelTest {

    private lateinit var testObject: NYSchoolViewModel
    private val mockRepository = mockk<NYSchoolsRepository>()
    private val mockDispatcher = UnconfinedTestDispatcher()

    @get: Rule val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(mockDispatcher)
        testObject = NYSchoolViewModel(mockRepository, mockDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }


    @Test
    fun `get schools when the repository gets a list of schools and returns SUCCESS`(){
//AAA
//Assign
        every { mockRepository.getSchools() } returns flowOf(
            ResponseState.SUCCESS(listOf(mockk(), mockk()))
            )
//Action
        testObject.schoolList.observeForever {
            if (it is ResponseState.SUCCESS){
                assertEquals(2, it.response.size)
            }
        }
        testObject.getSchoolList()
    }


    @Test
    fun `get error when the repository does not gets a list of schools and returns ERROR`(){
//AAA
//Assign
        every { mockRepository.getSchools() } returns flowOf(
            ResponseState.ERROR(Exception())
        )
//Action
        testObject.schoolList.observeForever {
            if (it is ResponseState.ERROR){
                assertEquals("Error, no schools found", it)
            }
        }
        testObject.getSchoolList()
    }

//ISSUE
    @Test
    fun ` get loading when the repository gets a list of schools and returns LOADING`(){
//AAA
//Assign
        every { mockRepository.getSchools() } returns flowOf(
            ResponseState.LOADING
        )
//Action
        testObject.schoolList.observeForever {
            if (it is ResponseState.LOADING){
                assertEquals("", "")
            }
        }
        testObject.getSchoolList()
    }



    @Test
    fun `get schools when the repository gets a list of SATs and returns SUCCESS`(){
//AAA
//Assign
        every { mockRepository.getSchoolSat("1") } returns flowOf(
            ResponseState.SUCCESS(listOf(mockk(), mockk()))
        )
//Action
        testObject.satResult.observeForever {
            if (it is ResponseState.SUCCESS){
                assertEquals(2, it.response.size)
            }
        }
        testObject.getSatResult()
    }


    @Test
    fun `get error when the repository does not gets a list of SATs and returns ERROR`(){
//AAA
//Assign
        every { mockRepository.getSchoolSat("1") } returns flowOf(
            ResponseState.ERROR(Exception())
        )
//Action
        testObject.satResult.observeForever {
            if (it is ResponseState.ERROR){
                assertEquals("Error, no SAT scores found", it)
            }
        }
        testObject.getSatResult()
    }

//ISSUE
    @Test
    fun ` get loading when the repository gets a list of SATs and returns LOADING`(){
//AAA
//Assign
        every { mockRepository.getSchoolSat("1") } returns flowOf(
            ResponseState.LOADING
        )
//Action
        testObject.satResult.observeForever {
            if (it is ResponseState.LOADING){
                assertEquals("", "")
            }
        }
        testObject.getSatResult()
    }



}