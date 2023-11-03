package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual

class RateOfReturnTest : FunSpec({

    test("수익률을 계산한다.") {
        val inputPrice = 14000
        val lottos = LottoStore.buyLottos(inputPrice)
        val winningLotto = Lotto(LottoStore.takeShuffleNumber(6))
        val winningResult = lottos.matchLotto(winningLotto)
        val rateOfReturn = RateOfReturn(inputPrice, winningResult).calculate()
        rateOfReturn shouldBeGreaterThanOrEqual 0.0
    }
})
