import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Speeding1Test {
    @Test fun `birthday going 86`() = assertEquals(
        Speeding1.caughtSpeeding(86, true), 2
    )

    @Test fun `birthday going 100`() = assertEquals(
        Speeding1.caughtSpeeding(100, true), 2
    )

    @Test fun `birthday going 66`() = assertEquals(
        Speeding1.caughtSpeeding(66, true), 1
    )

    @Test fun `birthday going 70`() = assertEquals(
        Speeding1.caughtSpeeding(70, true), 1
    )

    @Test fun `birthday going 85`() = assertEquals(
        Speeding1.caughtSpeeding(85, true), 1
    )

    @Test fun `birthday going 65`() = assertEquals(
        Speeding1.caughtSpeeding(65, true), 0
    )

    @Test fun `birthday going 30`() = assertEquals(
        Speeding1.caughtSpeeding(30, true), 0
    )

    @Test fun `not birthday going 81`() = assertEquals(
        Speeding1.caughtSpeeding(81, false), 2
    )

    @Test fun `not birthday going 100`() = assertEquals(
        Speeding1.caughtSpeeding(100, false), 2
    )

    @Test fun `not birthday going 61`() = assertEquals(
        Speeding1.caughtSpeeding(61, false), 1
    )

    @Test fun `not birthday going 65`() = assertEquals(
        Speeding1.caughtSpeeding(65, false), 1
    )

    @Test fun `not birthday going 80`() = assertEquals(
        Speeding1.caughtSpeeding(80, false), 1
    )

    @Test fun `not birthday going 60`() = assertEquals(
        Speeding1.caughtSpeeding(60, false), 0
    )

    @Test fun `not birthday going 30`() = assertEquals(
        Speeding1.caughtSpeeding(30, false), 0
    )

}