// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import com.gyoge.apcs.dog.DogKennel
import org.junit.jupiter.api.Test

class DogKennelTest : IOTest() {
    @Test fun `test kennel`() {
        DogKennel.main(arrayOf())

        assertOutput(
            """
                Dog{name='WolfieWolfie', breed='Huskie', weight=30.0}
                Dog{name='Sledder', breed='Part-Huskie', weight=40.0}
                Dog{name='Eclipse', breed='Mutt', weight=50.2}
                null
                null
                null
            """.trimIndent()
        )
    }
}
