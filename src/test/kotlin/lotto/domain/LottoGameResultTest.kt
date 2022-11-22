package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class LottoGameResultTest {

    @Test
    @DisplayName("일치하는 숫자가 3개일 경우 총 상금은 5000")
    fun `If there are three matching numbers, the total prize money is 5000`() {
        val resultOfWinning = LottoGameResult.getResultOfWinning(3)
        assertThat(resultOfWinning.prize).isEqualTo(BigDecimal(5000))
    }

    @Test
    @DisplayName("구매 가격이 10000이고 4등이 당첨되었다면 수익률은 0.5")
    fun `If the purchase price is 10000 and the 4th place wins, the yield is 0 dot 5`() {
        val gameResult = listOf(LottoGameResult.FOUR)
        val purchasingCost = BigDecimal(10000)

        val rate = LottoGameResult.rate(gameResult, purchasingCost)

        assertThat(rate).isEqualTo(BigDecimal(0.5))
    }
}
