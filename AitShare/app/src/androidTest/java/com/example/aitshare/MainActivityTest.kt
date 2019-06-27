package com.example.aitshare

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    private val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Before
    fun setUp() {
        activityRule.launchActivity(null)
        Espresso.registerIdlingResources(activityRule.activity.countingIdlingResource)
    }

    @Test
    fun activityTest(){
        onView(withId(R.id.id)).perform(typeText("16266"))
        onView(withId(R.id.password)).perform(typeText("123")).perform(closeSoftKeyboard())
        onView(withId(R.id.login)).perform(click())
        onView(withId(R.id.home)).check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
    }
}