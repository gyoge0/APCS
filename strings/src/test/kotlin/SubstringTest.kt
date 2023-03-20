// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import org.junit.jupiter.api.Test

class SubstringTest : IOTest() {
    @Test
    fun `Academies of Loudoun`() {
        setMockInput("Academies of Loudoun")

        Substring.main(arrayOf())
        assertOutput("In:The first 3 letters of Academies of Loudoun is Aca")
    }

    @Suppress("RemoveRedundantBackticks")
    @Test
    fun `banana`() {
        setMockInput("banana")

        Substring.main(arrayOf())
        assertOutput("In:The first 3 letters of banana is ban")
    }
}
