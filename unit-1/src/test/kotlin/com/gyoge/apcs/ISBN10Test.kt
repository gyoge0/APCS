package com.gyoge.apcs

import org.junit.jupiter.api.Test

class ISBN10Test : IOTest() {

    @Test fun `test ISBN10 of 13601267`() {
        ISBN10.testIsbn10(13601267)

        assertOutput(
            """
                ISBN-10: 13601267-1
                ==========================================
            """.trimIndent()
        )
    }

    @Test fun `test ISBN10 of 13031997`() {
        ISBN10.testIsbn10(13031997)

        assertOutput(
            """
                ISBN-10: 13031997-X
                ==========================================
            """.trimIndent()
        )
    }

    @Test fun `test ISBN10 of 158939758`() {
        ISBN10.testIsbn10(158939758)

        assertOutput(
            """
                ISBN-10: 158939758-4
                ==========================================
            """.trimIndent()
        )
    }
}
