package com.roynaldi19.pzna01_01androiddasar

import org.junit.Assert
import org.junit.Test

class HelloTest {

    @Test
    fun sayHello() {
        val result = Hello.sayHello("Roynaldi")

        Assert.assertEquals("Hello Roynaldi", result)
    }
}