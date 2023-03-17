package com.example.a20230310_carloscabrera_nycschools.Rest

import com.example.a20230310_carloscabrera_nycschools.tools.ResponseState
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NYSchoolsRepositoryImpTest {

    private lateinit var  testObject: NYSchoolsRepository
    private val mockApi = mockk<ServiceApi>(relaxed = true)
    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)


    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        testObject = NYSchoolsRepositoryImp(mockApi)


    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }


    @Test
    fun`get school info when the server gets a list of schools and returns a SUCCESS`(){
        //AAA
//Assignment
        coEvery { mockApi.getSchools() } returns mockk{
            every { isSuccessful } returns true
            every {body()} returns listOf(mockk(), mockk())
        }
//Action
        val job = testScope.launch {
            testObject.getSchools().collect {
                if (it is ResponseState.SUCCESS){
//Assert
                   assertEquals(2, it.response.size)
                }
            }
        }
        job.cancel()
    }


    @Test
    fun`get school info when the server gets a null list of schools and returns a ERROR`(){
        //AAA
//Assignment
        coEvery { mockApi.getSchools() } returns mockk{
            every { isSuccessful } returns true
            every {body()} returns null
        }
//Action
        val job = testScope.launch {
            testObject.getSchools().collect {
                if (it is ResponseState.ERROR){
//Assert
                    assertEquals("No Schools Available", it)
                }
            }
        }
        job.cancel()
    }


    @Test
    fun`get school info when the server gets a failure response of schools and returns a ERROR`(){
//AAA
// Assignment
        coEvery { mockApi.getSchools() } returns mockk{
            every { isSuccessful } returns false
            every {errorBody()} returns mockk{
                every { string() } returns "ERROR"
            }
        }
//Action
        val job = testScope.launch {
            testObject.getSchools().collect {
                if (it is ResponseState.ERROR){
//Assert
                    assertEquals("ERROR", it)
                }
            }
        }
        job.cancel()
    }


    @Test
    fun`get school info when the server gets throws an exception of schools and returns a ERROR`(){
//AAA
// Assignment
        coEvery { mockApi.getSchools() } throws Exception("ERROR")
//Action
        val job = testScope.launch {
            testObject.getSchools().collect {
                if (it is ResponseState.ERROR){
//Assert
                    assertEquals("ERROR", it)
                }
            }
        }
        job.cancel()
    }




    @Test
    fun`get SAT info when the server gets a list of schools and returns a SUCCESS`(){
        //AAA
//Assignment
        coEvery { mockApi.getSchoolSAT("1") } returns mockk{
            every { isSuccessful } returns true
            every {body()} returns listOf(mockk(), mockk())
        }
//Action
        val job = testScope.launch {
            testObject.getSchools().collect {
                if (it is ResponseState.SUCCESS){
//Assert
                    assertEquals(2, it.response.size)
                }
            }
        }
        job.cancel()
    }


    @Test
    fun`get SAT info when the server gets a null list of schools and returns a ERROR`(){
        //AAA
//Assignment
        coEvery { mockApi.getSchoolSAT("null") } returns mockk{
            every { isSuccessful } returns true
            every {body()} returns null
        }
//Action
        val job = testScope.launch {
            testObject.getSchools().collect {
                if (it is ResponseState.ERROR){
//Assert
                    assertEquals("No Schools Available", it)
                }
            }
        }
        job.cancel()
    }


    @Test
    fun`get SAT info when the server gets a failure response of schools and returns a ERROR`(){
//AAA
// Assignment
        coEvery { mockApi.getSchoolSAT("") } returns mockk{
            every { isSuccessful } returns false
            every {errorBody()} returns mockk{
                every { string() } returns "ERROR"
            }
        }
//Action
        val job = testScope.launch {
            testObject.getSchools().collect {
                if (it is ResponseState.ERROR){
//Assert
                    assertEquals("ERROR", it)
                }
            }
        }
        job.cancel()
    }


    @Test
    fun`get SAT info when the server gets throws an exception of schools and returns a ERROR`(){
//AAA
// Assignment
        coEvery { mockApi.getSchoolSAT("b") } throws Exception("ERROR")
//Action
        val job = testScope.launch {
            testObject.getSchools().collect {
                if (it is ResponseState.ERROR){
//Assert
                    assertEquals("ERROR", it)
                }
            }
        }
        job.cancel()
    }



}

