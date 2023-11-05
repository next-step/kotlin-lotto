package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual

class WinningRanksTest : BehaviorSpec({

    given("입력금액이 주어졌을 때") {
        val inputPrice = 14000
        val lottos = LottoStore.buyLottos(inputPrice, emptyList())
        val winningNumber = LottoStore.takeShuffleNumber(7)
        val bonusBall = winningNumber.numbers.last()
        val winningLottoNumber = LottoNumbers(winningNumber.numbers.take(6))
        val winningLotto = WinningLotto(winningLottoNumber, bonusBall)
        val winningResult = lottos.matchLotto(winningLotto)
        `when`("수익률을 계산한다.") {
            val rateOfReturn = winningResult.calculateRateOfReturn(inputPrice)
            then("수익률은 0.0이상이다.") {
                rateOfReturn shouldBeGreaterThanOrEqual 0.0
            }
        }
    }
})
