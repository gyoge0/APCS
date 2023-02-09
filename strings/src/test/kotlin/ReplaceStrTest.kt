// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import com.gyoge.apcs.ReplacePatterns.replacePattern
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("SpellCheckingInspection", "RemoveRedundantBackticks")
class ReplaceStrTest {
    @Test fun `kitty_dog_kitty`() = assertEquals(
        "kitty_dog_kitty".replace("kitty", "dog"),
        replacePattern("kitty_dog_kitty", "kitty", "dog"),
    )

    @Test fun `dog_kitty_dog`() = assertEquals(
        "dog_kitty_dog".replace("kitty", "dog"),
        replacePattern("dog_kitty_dog", "kitty", "dog"),
    )

    @Test fun `Mississippi iss`() = assertEquals(
        "Mississippi".replace("iss", "us"),
        replacePattern("Mississippi", "iss", "us"),
    )

    @Test fun `Mississippi ' i '`() = assertEquals(
        "Mississippi".replace(" i ", "ae"),
        replacePattern("Mississippi", " i ", "ae"),
    )

    @Test fun `long str e to a`() = assertEquals(
        "the effervescence in the teleconference was electrogeneses".replace("e", "a"),
        replacePattern("the effervescence in the teleconference was electrogeneses", "e", "a"),
    )
}
