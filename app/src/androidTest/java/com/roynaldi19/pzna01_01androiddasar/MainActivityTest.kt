package com.roynaldi19.pzna01_01androiddasar

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSayHello() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val name = "Roynaldi"

        onView(withId(R.id.edt_name))
            .perform(typeText(name))

        onView((withId(R.id.btn_sayHello)))
            .perform(click())

        onView(withId(R.id.tv_sayHello))
            .check(matches(withText(context.getString(R.string.say_hello_textView, name))))

    }


}