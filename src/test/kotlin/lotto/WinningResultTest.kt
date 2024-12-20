package lotto

import lotto.domain.LottoPrice
import lotto.domain.Rank
import lotto.domain.WinningResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningResultTest {
    @Test
    fun `번호 3개 일치시 당첨금은 5000원이다`() {
        val winningStatistics = mapOf(Rank.FOURTH to 1)
        val winningResult = WinningResult(winningStatistics)
        val prize = winningResult.calculateTotalPrize()
        assertThat(prize).isEqualTo(5000)
    }

    @Test
    fun `당첨되지 않은 경우 당첨금은 0원이다`() {
        val winningStatistics = mapOf(Rank.NONE to 1)
        val winningResult = WinningResult(winningStatistics)
        val prize = winningResult.calculateTotalPrize()
        assertThat(prize).isEqualTo(0)
    }

    @Test
    fun `당첨 갯수와 당첨금 수를 반환한다`() {
        val winningStatistics = mapOf(Rank.FOURTH to 1, Rank.THIRD to 2)
        val winningResult = WinningResult(winningStatistics)
        assertThat(winningResult.getWinningCount(Rank.FOURTH)).isEqualTo(1)
        assertThat(winningResult.getWinningCount(Rank.THIRD)).isEqualTo(2)
    }

    @Test
    fun `총 당첨금을 계산한다`() {
        val winningStatistics =
            mapOf(
                Rank.FOURTH to 2,
                Rank.THIRD to 1,
                Rank.SECOND to 1,
            )
        val winningResult = WinningResult(winningStatistics)
        val prize = winningResult.calculateTotalPrize()
        val expectedPrize = (5_000 * 2) + (50_000 * 1) + (30_000_000 * 1)
        assertThat(prize).isEqualTo(expectedPrize)
    }

    @Test
    fun `수익률을 계산한다`() {
        val winningStatistics = mapOf(Rank.FOURTH to 1)
        val purchaseAmount = LottoPrice(10000)
        val winningResult = WinningResult(winningStatistics)
        val profitRate = winningResult.calculateProfitRate(purchaseAmount)
        assertThat(profitRate).isEqualTo(0.5)
    }
}
