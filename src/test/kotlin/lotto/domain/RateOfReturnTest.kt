package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual

class RateOfReturnTest : FunSpec({

    test("수익률을 계산한다.") {
        val inputPrice = 14000
        val lottos = LottoStore.buyLottos(inputPrice, emptyList())
        val winningNumber = LottoStore.takeShuffleNumber(7)
        val bonusBall = winningNumber.numbers.last()
        val winningLottoNumber = LottoNumbers(winningNumber.numbers.take(6))
        val winningLotto = WinningLotto(winningLottoNumber, bonusBall)
        val winningResult = lottos.matchLotto(winningLotto)
        val rateOfReturn = RateOfReturn(inputPrice, winningResult).calculate()
        rateOfReturn shouldBeGreaterThanOrEqual 0.0
    }
})
