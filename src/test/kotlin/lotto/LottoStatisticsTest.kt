package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStatisticsTest {
    @Test
    fun `특정 등수의 개수를 반환한다`() {
        val ranks = Ranks(mapOf(Rank.FIRST to 2, Rank.SECOND to 1, Rank.THIRD to 3))
        val amount = Amount(5000)
        val statistics = LottoStatistics(ranks, amount)

        val actual = statistics.machRankCount(Rank.SECOND)

        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `수익률을 계산한다`() {
        val ranks = Ranks(mapOf(Rank.FOURTH to 1))
        val amount = Amount(3000)
        val statistics = LottoStatistics(ranks, amount)

        val rate = statistics.rate()

        assertThat(rate).isEqualTo(1.66.toBigDecimal())
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
