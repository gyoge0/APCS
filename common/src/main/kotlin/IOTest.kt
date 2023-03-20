// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

/**
 * Base class with methods for testing console IO
 */
abstract class IOTest {
    private val stdout = System.out
    private val stdin = System.`in`
    private var mockOutput: ByteArrayOutputStream? = null
    private var mockInput: ByteArrayInputStream? = null

    @BeforeEach
    fun setOutput() {
        mockOutput = ByteArrayOutputStream()
        System.setOut(PrintStream(mockOutput!!))
    }

    protected fun setMockInput(input: String) {
        mockInput = ByteArrayInputStream(input.toByteArray())
        System.setIn(mockInput)
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun getOutput(): String? {
        return mockOutput?.toString()
    }

    protected fun assertOutput(expected: String) = assertEquals(
        expected.trim().replace("\r\n", "\n"),
        getOutput()?.trim()?.replace("\r\n", "\n")
    )

    @AfterEach
    fun resetIO() {
        System.setOut(stdout)
        System.setIn(stdin)
    }
}
