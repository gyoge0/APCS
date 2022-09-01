package com.gyoge.apcs

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SumOddsInRangeTest {
    @Test fun `sum odds in range 4-20`() = assertEquals(
        SumOddsInRange.sumOddsInRange(4, 20),
        96
    )

    @Test fun `sum odds in range 3-11`() = assertEquals(
        SumOddsInRange.sumOddsInRange(3, 11),
        35
    )
}
