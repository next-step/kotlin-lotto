package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfitCalculationTest {

    @Test
    fun `14000원에 5000원 1개 당첨이면 수익률은 0점35이다`() {
        val lottoGame = LottoGame(listOf(1, 2, 3, 4, 5, 6))
        lottoGame.addMatchedLottoRankCount(LottoRank.FOURTH)
        val profitCalculation = ProfitCalculation()

        assertThat(profitCalculation.getProfitRate(lottoGame, 14000)).isEqualTo(0.35f)
    }
}
