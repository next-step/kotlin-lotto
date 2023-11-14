@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningStatisticTest {
    @Test
    fun `당첨 리스트와 구입 금액으로 당첨 통계를 생성하면 수익률을 가진다`() {
        val prizes = listOf(Prize.FIRST, Prize.SECOND)
        val purchaseAmount = Won(15000)

        val actual = WinningStatistic(prizes, purchaseAmount).profitRate

        val totalWinningAmount = prizes.sumOf { it.winningAmount.amount }

        assertThat(actual).isEqualTo(totalWinningAmount / purchaseAmount.amount.toDouble())
    }

    @Test
    fun `당첨 리스트와 구입 금액으로 당첨 통계를 생성하면 당첨 등수 별 수를 가진다`() {
        val prizes = listOf(Prize.THIRD, Prize.FOURTH, Prize.FOURTH)
        val purchaseAmount = Won(15000)

        val actual = WinningStatistic(prizes, purchaseAmount).countPerPrize

        assertThat(actual[Prize.THIRD]).isEqualTo(1)
        assertThat(actual[Prize.FOURTH]).isEqualTo(2)
    }
}
