// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import org.junit.jupiter.api.Test

@Suppress("SpellCheckingInspection", "RemoveRedundantBackticks")
class ReverseStringTest : IOTest() {
    @Test fun `processor`() {
        setMockInput("processor")

        ReverseString.main(arrayOf())
        assertOutput("In:rossecorp")
    }

    @Test fun `racecars`() {
        setMockInput("racecars")

        ReverseString.main(arrayOf())
        assertOutput("In:sracecar")
    }

    @Test fun `manhattan`() {
        setMockInput("manhattan")

        ReverseString.main(arrayOf())
        assertOutput("In:nattahnam")
    }
}
