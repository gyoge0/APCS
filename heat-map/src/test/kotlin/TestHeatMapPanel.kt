// Yogesh Thambidurai APCS 2022-23
import com.gyoge.apcs.HeatMapPanel.getBlue
import com.gyoge.apcs.HeatMapPanel.getGreen
import com.gyoge.apcs.HeatMapPanel.getRed
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestHeatMapPanel {
    @Nested
    inner class TestRed {
        @Test fun `5`() = assertEquals(255, getRed(5.0))

        @Test fun `0`() = assertEquals(255, getRed(0.0))

        @Test fun `-37`() = assertEquals(128, getRed(-37.0))

        @Test fun `-74`() = assertEquals(0, getRed(-74.0))

        @Test fun `-75`() = assertEquals(0, getRed(-75.0))

        @Test fun `-150`() = assertEquals(0, getRed(-150.0))
    }

    @Nested
    inner class TestGreen {
        @Test fun `150`() = assertEquals(0, getGreen(150.0))

        @Test fun `76`() = assertEquals(255, getGreen(76.0))

        @Test fun `75`() = assertEquals(255, getGreen(75.0))

        @Test fun `3`() = assertEquals(255, getGreen(3.0))

        @Test fun `-74`() = assertEquals(255, getGreen(-74.0))

        @Test fun `-75`() = assertEquals(255, getGreen(-75.0))

        @Test fun `-130`() = assertEquals(68, getGreen(-130.0))

        @Test fun `-150`() = assertEquals(0, getGreen(-150.0))
    }

    @Nested
    inner class TestBlue {
        @Test fun `-75`() = assertEquals(255, getBlue(-75.0))

        @Test fun `0`() = assertEquals(255, getBlue(0.0))

        @Test fun `1`() = assertEquals(255, getBlue(1.0))

        @Test fun `38`() = assertEquals(128, getBlue(38.0))

        @Test fun `75`() = assertEquals(0, getBlue(75.0))

        @Test fun `76`() = assertEquals(0, getBlue(76.0))
    }
}
