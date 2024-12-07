package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe

class LottoProfitRateCalculatorTest : FreeSpec({
    "구매한 로또 금액과 당첨된 로또 금액을 비교하여 수익률을 계산한다" {
        val twoOfForthLotto =
            UserLottos(
                listOf(
                    Lotto(1, 2, 3, 43, 44, 45),
                    Lotto(1, 2, 3, 43, 44, 45),
                ),
            )
        val lottoResults = LottoResults(listOf(LottoRank.FIFTH, LottoRank.FIFTH))

        val profitRate: Double = LottoProfitRateCalculator.calculate(twoOfForthLotto, lottoResults)

        profitRate shouldBe (5.0 plusOrMinus 0.0001)
    }
})
