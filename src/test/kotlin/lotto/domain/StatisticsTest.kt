package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StatisticsTest {

    @Test
    fun `로또 당첨 개수와 구입 개수가 주어질 때 수익률 계산01`() {
        map[PrizeGenerator.THREE_MATCH] = 1
        assertThat(LottoStatistics.calculateRatio(3)).isEqualTo(1.67.toBigDecimal())
    }

    @Test
    fun `로또 당첨 개수와 구입 개수가 주어질 때 수익률 계산02`() {
        map[PrizeGenerator.THREE_MATCH] = 1
        map[PrizeGenerator.FIVE_MATCH] = 1
        assertThat(LottoStatistics.calculateRatio(30)).isEqualTo(50.17.toBigDecimal())
    }

    @Test
    fun `구입금액 150_000_000원이 주어지고, 5개 번호 일치하며 2등도 당첨된 경우 수익률은`() {
        map[PrizeGenerator.FIVE_MATCH] = 1
        map[PrizeGenerator.BONUS_MATCH] = 1
        assertThat(LottoStatistics.calculateRatio(150_000)).isEqualTo(0.21.toBigDecimal())
    }
}
