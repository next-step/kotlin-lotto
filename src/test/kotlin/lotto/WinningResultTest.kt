package lotto

import WinningResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningResultTest {

    @Test
    fun `번호 3개 일치시 당첨금은 5000원이다`() {
        val winningStatistics = mapOf(3 to 1)
        val winningResult = WinningResult(winningStatistics)
        val prize = winningResult.calculateTotalPrize()
        assertThat(prize).isEqualTo(5000)
    }

    @Test
    fun `당첨되지 않은 경우 당첨금은 0원이다`() {
        val winningStatistics = mapOf(2 to 1)
        val winningResult = WinningResult(winningStatistics)
        val prize = winningResult.calculateTotalPrize()
        assertThat(prize).isEqualTo(0)
    }

    @Test
    fun `당첨 갯수와 당첨금 수를 반환한다`() {
        val winningStatistics = mapOf(3 to 1, 4 to 2)
        val winningResult = WinningResult(winningStatistics)
        assertThat(winningResult.getWinningCount(3)).isEqualTo(1)
        assertThat(winningResult.getWinningCount(4)).isEqualTo(2)
        assertThat(winningResult.getWinningCount(5)).isEqualTo(0)
    }

    @Test
    fun `총 당첨금을 계산한다`() {
        val winningStatistics = mapOf(
            3 to 2,
            4 to 1,
            5 to 1
        )
        val winningResult = WinningResult(winningStatistics)
        val prize = winningResult.calculateTotalPrize()
        val expectedPrize = (5000 * 2) + (50000 * 1) + (1500000 * 1)
        assertThat(prize).isEqualTo(expectedPrize)
    }

    @Test
    fun `수익률을 계산한다`() {
        val winningStatistics = mapOf(3 to 1)  // 5,000원
        val purchaseAmount = 10000  // 10장 구매
        val winningResult = WinningResult(winningStatistics)
        val profitRate = winningResult.calculateProfitRate(purchaseAmount)
        assertThat(profitRate).isEqualTo(0.5)  // 5000 / 10000 = 0.5
    }

}
