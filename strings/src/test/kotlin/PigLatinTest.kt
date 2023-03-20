// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import com.gyoge.apcs.PigLatin.pig
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("SpellCheckingInspection")
class PigLatinTest {
    @Test
    fun `pig to igpay`() = assertEquals(
        "igpay",
        pig("pig"),
    )

    @Test
    fun `latin to atinlay`() = assertEquals(
        "atinlay",
        pig("latin"),
    )

    @Test
    fun `this to isthay`() = assertEquals(
        "isthay",
        pig("this"),
    )

    @Test
    fun `strange to angestray`() = assertEquals(
        "angestray",
        pig("strange"),
    )

    @Test
    fun `invalid test`() = assertEquals(
        "**** INVALID ****",
        pig("bcdfgh"),
    )

    @Nested
    inner class QuCase {

        @Test
        fun `question to estionquay`() = assertEquals(
            "estionquay",
            pig("question"),
        )

        @Test
        fun `squeeze to eezesquay`() = assertEquals(
            "eezesquay",
            pig("squeeze"),
        )
    }

    @Nested
    inner class YCases {
        @Test
        fun `yes to esyay`() = assertEquals(
            "esyay",
            pig("yes"),
        )

        @Test
        fun `rhyme to ymerhay`() = assertEquals(
            "ymerhay",
            pig("rhyme"),
        )

        @Test
        fun `try to ytray`() = assertEquals(
            "ytray",
            pig("try"),
        )
    }

    @Nested
    inner class Capitalization {
        @Test
        fun `Thomas to Omasthay`() = assertEquals(
            "Omasthay",
            pig("Thomas"),
        )

        @Test
        fun `Jefferson to Effersonjay`() = assertEquals(
            "Effersonjay",
            pig("Jefferson"),
        )

        @Test
        fun `McDonald to OnaldmcDay`() = assertEquals(
            "OnaldmcDay",
            pig("McDonald"),
        )

        @Test
        fun `McArthur to Arthurmcay`() = assertEquals(
            "Arthurmcay",
            pig("McArthur"),
        )
    }

    @Suppress("DANGEROUS_CHARACTERS")
    @Nested
    inner class Punctuation {
        @Test
        fun `What? to Atwhay?`() = assertEquals(
            "Atwhay?",
            pig("What?"),
        )

        @Test
        fun `Oh! to Ohway!`() = assertEquals(
            "Ohway!",
            pig("Oh!"),
        )

        @Test
        fun `"hello" to "ellohay"`() = assertEquals(
            "ellohay",
            pig("hello"),
        )

        @Test
        fun `"Hello!!!!" to "Ellohay!!!!"`() = assertEquals(
            "Ellohay!!!!",
            pig("Hello!!!!"),
        )

        @Test
        fun `don't to on'tday`() = assertEquals(
            "on'tday",
            pig("don't"),
        )
    }
}
