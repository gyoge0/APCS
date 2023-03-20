// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import com.gyoge.apcs.password.Password
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/** Tester file used here for tests */
@Suppress("RemoveRedundantBackticks", "SpellCheckingInspection")
class PasswordTest {
    @Test
    fun `spaces no digit no special character`() {
    }

    @Test
    fun `all`() = assertEquals(
        "no lower case letters, no upper case letters, contains spaces, no digits",
        Password(".. .. ..").invalidReason,
    )

    @Test
    fun `passing`() = assertEquals(
        null,
        Password("heyThere1234!").invalidReason,
    )

    @Test
    fun `no special character`() = assertEquals(
        "no special characters",
        Password("heyThere1234").invalidReason,
    )

    @Test
    fun `too short`() = assertEquals(
        "too short",
        Password("hey").invalidReason,
    )

    @Test
    fun `too long`() = assertEquals(
        "too long",
        Password("1234567891011121314151617181920").invalidReason,
    )

    @Test
    fun `no lowercase`() = assertEquals(
        "no lower case letters",
        Password("HEYTHERE1234!").invalidReason,
    )

    @Test
    fun `no upper case`() = assertEquals(
        "no upper case letters",
        Password("heythere1234!").invalidReason,
    )
}
