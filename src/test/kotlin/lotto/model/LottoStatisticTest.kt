package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoStatisticTest {
    @Test
    @DisplayName("로또 당첨된 사람이 있는 경우의 수익률 계산")
    fun `check profit when is has winner`() {
        // given
        val price = Price(1000)
        val winList = hashMapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 0,
            LottoRank.FOURTH to 0,
            LottoRank.FIFTH to 0
        )

        // when
        val statistic = LottoStatisticFormat(price, winList)
        val expectedProfit = ((LottoRank.FIRST.winningMoney * 1) / price.price).toDouble()

        // then
        Assertions.assertThat(statistic.profit)
            .isEqualTo(expectedProfit)
    }

    @Test
    @DisplayName("로또 당첨된 사람이 있는 경우의 수익률 계산")
    fun `check profit when it has none winner`() {
        // given
        val price = Price(1000)
        val winList = hashMapOf(
            LottoRank.FIRST to 0,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 0,
            LottoRank.FOURTH to 0,
            LottoRank.FIFTH to 0
        )

        // when
        val statistic = LottoStatisticFormat(price, winList)
        val expectedProfit = (0 / price.price).toDouble()

        // then
        Assertions.assertThat(statistic.profit)
            .isEqualTo(expectedProfit)
    }
}
