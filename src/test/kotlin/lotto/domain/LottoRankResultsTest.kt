package lotto.domain

import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoRankResultsTest {
    @Test
    fun `각 등수의 담청 된 개수 알 수 있다`() {
        // given
        val prize = Rank.FIRST
        val results = listOf(prize)
        val lottoRankResults = LottoRankResults(results)

        // when
        val count = lottoRankResults.count(prize)

        // then
        assertThat(count).isEqualTo(1)
    }

    @Test
    fun `수익률을 계산할 수 있다`() {
        // given
        val results = listOf(Rank.FIFTH)
        val purchaseAmount = 1000
        val lottoRankResults = LottoRankResults(results)

        // when
        val returnOnInvestment = lottoRankResults.returnOnInvestment(purchaseAmount)

        // then
        assertThat(returnOnInvestment).isEqualTo(5.0)
    }

    @Test
    fun `수익률을 소숫점이하 2자리로 반올림한다`() {
        // given
        val results = listOf(Rank.FOURTH, Rank.FIFTH)
        val purchaseAmount = 140000
        val lottoRankResults = LottoRankResults(results)

        // when
        val returnOnInvestment = lottoRankResults.returnOnInvestment(purchaseAmount)

        // then
        assertThat(returnOnInvestment).isEqualTo(.39)
    }
}
