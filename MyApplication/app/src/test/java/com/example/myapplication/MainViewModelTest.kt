package com.example.myapplication

import app.cash.turbine.test
import com.example.myapplication.data.School
import com.example.myapplication.repositorys.Repository
import com.example.myapplication.viewmodels.ListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private lateinit var viewModel : ListViewModel
    private lateinit var repository: Repository

    @get:Rule
    val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp(){

        repository = mock(Repository::class.java)
        viewModel = ListViewModel(repository)

        Dispatchers.setMain(dispatcher)
    }
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun testViewModelWithListOfData() = runTest {
        val mockItems = listOf(
            School(dbn = "jfg" , school_name = "test" , overview_paragraph = "Lorem inpuls " , directions1 = "Northeeast" , requirement1_1 = "" , "","","",
                "","","",""),
            School(dbn = "jff" , school_name = "test" , overview_paragraph = "Lorem inpuls " , directions1 = "Northeeast" , requirement1_1 = "" , "","","",
                "","","",""),
            School(dbn = "jfg" , school_name = "test" , overview_paragraph = "Lorem inpuls " , directions1 = "Northeeast" , requirement1_1 = "" , "","","",
                "","","",""),

                    School(dbn = "jfg" , school_name = "test" , overview_paragraph = "Lorem inpuls " , directions1 = "Northeeast" , requirement1_1 = "" , "","","",
            "","","","")
        )

        `when`(repository.getSchoolList()).thenReturn(flowOf( mockItems))

        viewModel.list.test {
            val emitedData = awaitItem()
            assertEquals(4,emitedData.size)
            assertEquals("jfg",emitedData[0].dbn)
            assertEquals("jff",emitedData[1].dbn)

        }
    }

}