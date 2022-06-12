package lotto.domain

import lotto.domain.model.LottoRank
import lotto.domain.model.LottoResult
import lotto.domain.model.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoLottoYieldCalculatorTest {
    @Test
    fun `calculate를 통해 lottoResult와 구입 금액을 받아 수익률을 계산할 수 있다`() {
        val lottoWinnings = mapOf(
            LottoRank.FIFTH to 2,
            LottoRank.FOURTH to 2,
            LottoRank.THIRD to 1
        )

        val lottoResult = LottoResult.from(lottoWinnings)
        val purchaseAmount = Money.from(13000)

        val expected = lottoResult.getTotalEarns().toDouble() / purchaseAmount.value.toDouble()

        assertThat(LottoYieldCalculator.calculate(lottoResult, purchaseAmount).value).isEqualTo(expected)
    }
}
