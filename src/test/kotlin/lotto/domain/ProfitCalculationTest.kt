package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfitCalculationTest {

    @Test
    fun `14000원에 5000원 1개 당첨이면 수익률은 0점35이다`() {
        val lottoRanks = mapOf(LottoRank.FOURTH to 1)
        val profitCalculation = ProfitCalculation()
        assertThat(profitCalculation.getProfitRate(lottoRanks, 14000)).isEqualTo(0.35f)
    }
}
