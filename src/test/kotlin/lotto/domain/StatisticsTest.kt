package lotto.domain

import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
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

    @ParameterizedTest
    @CsvSource(
        value = [
            "5000, 3, 1.7",
            "1500000, 30, 50.0"
        ]
    )
    fun `당첨 금액와 구입 로또 개수가 주어질 때 수익률 계산`(amount: Int, purchaseCount: Int, ratio: Double) {
        val statistics = spy(Statistics)
        whenever(statistics.winningAmount()).thenReturn(amount)

        assertThat(statistics.calculateRatio(purchaseCount)).isEqualTo(ratio)
    }
}
