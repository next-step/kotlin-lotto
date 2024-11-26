package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class LottoStatisticsTest {
    @Test
    fun `특정 등수의 개수를 반환한다`() {
        val ranks = Ranks(mapOf(Rank.FIRST to 2, Rank.SECOND to 1, Rank.THIRD to 3))
        val amount = Amount(5000)
        val statistics = LottoStatistics(ranks, amount)

        val actual = statistics.machRankCount(Rank.SECOND)

        assertThat(actual).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "FIRST, 1000000, 2000.00",
            "SECOND, 1000000, 30.00",
            "THIRD, 1000000, 1.50",
            "FOURTH, 10000, 5.00",
            "FIFTH, 3000, 1.66",
            "MISS, 3000, 0.00",
        ],
        delimiter = ',',
    )
    fun `수익률을 계산한다`(
        rank: Rank,
        initAmount: Int,
        expectedRate: BigDecimal,
    ) {
        val ranks = Ranks(mapOf(rank to 1))
        val amount = Amount(initAmount)
        val statistics = LottoStatistics(ranks, amount)

        val rate = statistics.rate()

        assertThat(rate).isEqualTo(expectedRate)
    }

    @Test
    fun `손실인지 여부를 반환한다`() {
        val ranks = Ranks(mapOf(Rank.FIRST to 1))
        val amount = Amount(5000)
        val statistics = LottoStatistics(ranks, amount)

        val isLoss = statistics.isLoss()

        assertThat(isLoss).isFalse()
    }
}
