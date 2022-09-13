// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import org.junit.jupiter.api.Test

class FibonacciTest : IOTest() {
    @Test fun `test first 9 Fibonacci`() {
        setMockInput("9")
        Fibonacci.main(arrayOf())

        assertOutput(
            "In: 0 1 1 2 3 5 8 13 21"
        )
    }
}
