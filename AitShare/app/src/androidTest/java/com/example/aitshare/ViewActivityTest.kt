package com.example.aitshare

import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ViewActivityTest {

    @Rule
    private val activityTestRule = ActivityTestRule(ViewActivity::class.java, false, false)

    @Before
    fun setUp() {
        activityTestRule.launchActivity(null)
        Espresso.registerIdlingResources(activityTestRule.activity.countingIdlingResource)
    }

    @Test
    fun viewActivityTest(){

    }

    @After
    fun tearDown() {
        Espresso.unregisterIdlingResources(activityTestRule.activity.countingIdlingResource)
    }
}