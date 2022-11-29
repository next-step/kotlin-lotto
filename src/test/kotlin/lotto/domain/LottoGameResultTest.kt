package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class LottoGameResultTest {

    @Test
    @DisplayName("일치하는 숫자가 3개일 경우 총 상금은 5000")
    fun `If there are three matching numbers, the total prize money is 5000`() {
        val resultOfWinning = LottoGameResult.getResultOfWinning(3, 0)
        assertThat(resultOfWinning.prize).isEqualTo(BigDecimal(5000))
    }

    @Test
    @DisplayName("구매 가격이 10000이고 5등이 당첨되었다면 수익률은 0.5")
    fun `If the purchase price is 10000 and the 5th place wins, the yield is 0 dot 5`() {
        val gameResult = listOf(LottoGameResult.FIFTH)
        val purchasingCost = BigDecimal(10000)

        val rate = LottoGameResult.rate(gameResult, purchasingCost)

        assertThat(rate).isEqualTo(BigDecimal(0.5))
    }

    @Test
    @DisplayName("구매 가격이 3000이고 1등이 당첨되었다면 수익률은 666666.67")
    fun `If the purchase price is 3000 and the winner wins, the yield is 666666 dot 67`() {
        val gameResult = listOf(LottoGameResult.FIRST)
        val purchasingCost = BigDecimal(3000)

        val rate = LottoGameResult.rate(gameResult, purchasingCost)
        val expectedValue = 666666.67.toBigDecimal()

        assertThat(rate).isEqualTo(expectedValue)
    }

    @Test
    @DisplayName("1등이 3번 당첨되었을 경우 당첨 횟수는 3번")
    fun `If the winner wins 3 times, the number of wins will be 3 times`() {
        val gameResult = listOf(LottoGameResult.FIRST, LottoGameResult.FIRST, LottoGameResult.FIRST)
        val statistics = LottoGameResult.winningStatistics(gameResult)
        val count = statistics[LottoGameResult.FIRST]
        assertThat(count).isEqualTo(3)
    }

    @Test
    @DisplayName("일치하는 숫자가 5개고 보너스 번호를 맞춘경우 2등 당첨")
    fun `If there are 5 matching numbers and the bonus number is matched, the second prize`() {
        val gameResult = LottoGameResult.getResultOfWinning(5, 1)
        assertThat(gameResult).isEqualTo(LottoGameResult.SECOND)
    }

    @Test
    @DisplayName("일치하는 숫자가 3개고 보너스 번호를 맞춘경우 5등")
    fun `If there are 3 matching numbers and you get the bonus number, you're in 5th place`() {
        val gameResult = LottoGameResult.getResultOfWinning(3, 1)
        assertThat(gameResult).isEqualTo(LottoGameResult.FIFTH)
    }
}
