package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStatisticsTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "10, 1, 1, 150.50"
        ]
    )
    fun `당첨 결과와 로또 구매 개수가 주어지면 통계를 구한다`(purchasedCount: Int, threeMatched: Int, fiveMatched: Int, expected: String) {
        result[PrizeResult.FIFTH] = threeMatched
        result[PrizeResult.THIRD] = fiveMatched

        val ratio = LottoStatistics.calculateRatio(purchasedCount)
        assertThat(ratio).isEqualTo(expected.toBigDecimal())
    }
}
