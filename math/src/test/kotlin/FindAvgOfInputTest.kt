// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import org.junit.jupiter.api.Test

class FindAvgOfInputTest : IOTest() {
    @Test fun `5 7 2 5`() {
        setMockInput("5\n7\n2\n5\n9999")

        FindAvgOfInput.main(arrayOf())
        assertOutput("Enter a number or 9999 to quit: Enter a number or 9999 to quit: Enter a number or 9999 to quit: Enter a number or 9999 to quit: Enter a number or 9999 to quit: The average is 4.75")
    }

    @Test fun `9999`() {
        setMockInput("9999")

        FindAvgOfInput.main(arrayOf())
        assertOutput("Enter a number or 9999 to quit: The average is 0.0")
    }
}
