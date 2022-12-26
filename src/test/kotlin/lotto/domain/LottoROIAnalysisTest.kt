package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoROIAnalysisTest {
    @Test
    fun `수익률을 계산할 수 있다`() {
        // given
        val winningPrize = 1000
        val purchaseAmount = 2000
        val lottoROIAnalysis = LottoROIAnalysis()

        // when
        val returnOnInvestment = lottoROIAnalysis.returnOnInvestment(winningPrize, purchaseAmount)

        // then
        assertThat(returnOnInvestment).isEqualTo(.5)
    }
}
