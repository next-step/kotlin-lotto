package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe

class LottoProfitRateCalculatorTest : FreeSpec({
    "구매한 로또 금액과 당첨된 로또 금액을 비교하여 수익률을 계산한다" {
        val 두장의_4등_로또 =
            UserLottos(
                listOf(
                    Lotto(setOf(1, 2, 3, 43, 44, 45)),
                    Lotto(setOf(1, 2, 3, 43, 44, 45)),
                ),
            )
        val winningLotto = WinningLotto(setOf(1, 2, 3, 4, 5, 6))

        val lottoResults = LottoResultChecker.check(userLottos = 두장의_4등_로또, winningLotto = winningLotto)
        val profitRate: Double = LottoProfitRateCalculator.calculate(두장의_4등_로또, lottoResults)

        profitRate shouldBe (5.0 plusOrMinus 0.0001)
    }
})
