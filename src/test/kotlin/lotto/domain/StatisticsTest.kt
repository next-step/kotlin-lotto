package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StatisticsTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "3, 1",
            "3, 2",
            "3, 3"
        ]
    )
    fun `로또 당첨 개수가 주어질 때, Statistics의 등수의 카운트가 정상적으로 입력되는지 확인`(winningCount: Int, expected: Int) {
        Statistics.countRank(winningCount)
        assertEquals(Statistics.count_3, expected)
    }
}
