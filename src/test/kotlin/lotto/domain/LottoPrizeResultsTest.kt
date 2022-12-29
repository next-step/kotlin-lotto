package lotto.domain

import lotto.model.LottoPrize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoPrizeResultsTest {
    @Test
    fun `각 등수의 담청 된 개수 알 수 있다`() {
        // given
        val prize = LottoPrize.FIRST
        val results = listOf(prize)
        val lottoPrizeResults = LottoPrizeResults(results)

        // when
        val count = lottoPrizeResults.count(prize)

        // then
        assertThat(count).isEqualTo(1)
    }

    @Test
    fun `수익률을 계산할 수 있다`() {
        // given
        val results = listOf(LottoPrize.FOURTH)
        val purchaseAmount = 1000
        val lottoPrizeResults = LottoPrizeResults(results)

        // when
        val returnOnInvestment = lottoPrizeResults.returnOnInvestment(purchaseAmount)

        // then
        assertThat(returnOnInvestment).isEqualTo(5.0)
    }

    @Test
    fun `수익률을 소숫점이하 2자리로 반올림한다`() {
        // given
        val results = listOf(LottoPrize.THIRD, LottoPrize.FOURTH)
        val purchaseAmount = 140000
        val lottoPrizeResults = LottoPrizeResults(results)

        // when
        val returnOnInvestment = lottoPrizeResults.returnOnInvestment(purchaseAmount)

        // then
        assertThat(returnOnInvestment).isEqualTo(.39)
    }
}
