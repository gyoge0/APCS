// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SumDigitReverseDigitTest {
    @Test fun `sum digits 12345`() = assertEquals(
        SumDigitReverseDigit.sumDigits(12345),
        15,
    )

    @Test fun `reverse digits 12345`() = assertEquals(
        SumDigitReverseDigit.reverseDigits(12345),
        54321,
    )
}
