package lotto

import org.junit.jupiter.api.Test

internal class StatisticsTest {

    @Test
    fun hello() {
        val result = Statistics.get(
            "1,2,3,4,5,6", listOf(
                Lotto(setOf(1, 2, 3, 4, 5, 6)),
                Lotto(setOf(1, 2, 3, 10, 11, 12)),
                Lotto(setOf(1, 2, 3, 10, 11, 12)),
            ), 14000
        ).joinToString("\n")

        println(result)
    }
}
