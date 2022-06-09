package lotto.domain

import lotto.domain.model.LottoRank
import lotto.domain.model.LottoResult
import lotto.domain.model.LottoWinning
import lotto.domain.model.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoLottoYieldCalculatorTest {
    @Test
    fun `calculate를 통해 lottoResult와 구입 금액을 받아 수익률을 계산할 수 있다`() {
        val lottoResult = LottoResult(
            listOf(
                LottoWinning(LottoRank.FIFTH, 2),
                LottoWinning(LottoRank.FOURTH, 2),
                LottoWinning(LottoRank.THIRD, 1),
                LottoWinning(LottoRank.SECOND, 0),
                LottoWinning(LottoRank.FIRST, 0)
            )
        )
        val purchaseAmount = Money.from(13000)

        val expected = lottoResult.getTotalEarns().toDouble() / purchaseAmount.value.toDouble()

        assertThat(LottoYieldCalculator.calculate(lottoResult, purchaseAmount).value).isEqualTo(expected)
    }
}
