package com.projeto.movielist.activity

import com.projeto.movielist.view.MovieListActivity
import com.projeto.test.ui.base.ActivityTest
import com.projeto.test.ui.base.ActivityTestRule
import com.projeto.test.ui.base.onActivity
import com.projeto.test.ui.robot.check
import net.bytebuddy.utility.RandomString
import org.junit.Rule
import org.junit.Test

internal class MovieListActivityUITest : ActivityTest<MovieListActivityUIRobot> {

    @get:Rule
    override val rule = ActivityTestRule(MovieListActivity::class.java)

    @Test
    fun whenAtSucessState_shouldShowMovieList() {
        onActivity {
            setSuccessState()
        } check {
            checkListIsDisplayed(true)
            checkErrorIsDisplayed(false)
            checkLoadingIsDisplayed(false)
            checkSizeMovieRecyclerView(2)
            labelAtPositionIs(0, "Avatar")
            labelAtPositionIs(1, "Avatar: The Last Airbender")
        }
    }

    @Test
    fun whenAtErrorState_shouldShowErrorMessage() {
        val randomString = RandomString().nextString()
        onActivity {
            setErrorState(randomString)
        } check {
            checkListIsDisplayed(false)
            checkErrorIsDisplayed(true)
            checkLoadingIsDisplayed(false)
            messageErrorOnTextViewIs(randomString)
        }
    }

    @Test
    fun whenAtLoadingState_shouldShowLoadingDialog() {
        onActivity {
            setLoadingState()
        } check {
            checkListIsDisplayed(false)
            checkErrorIsDisplayed(false)
            checkLoadingIsDisplayed(true)
        }
    }

}