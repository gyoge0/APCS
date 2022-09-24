// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReverseAndSubtractTest {
    @Test fun `test 541 and 329`() = assertEquals(
        -778,
        ReverseAndSubtract.reverseAndSubtract(541, 329)
    )

    @Test fun `test 155 and 0`() = assertEquals(
        551,
        ReverseAndSubtract.reverseAndSubtract(155, 0)
    )

    @Test fun `test 544 and 322`() = assertEquals(
        222,
        ReverseAndSubtract.reverseAndSubtract(544, 322)
    )
}
