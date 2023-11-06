package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual

class WinningRanksTest : BehaviorSpec({

    given("입력금액이 주어졌을 때") {
        val inputPrice = 1000
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val lottoNumberAutoGenerator = LottoNumberAutoGenerator { lottoNumbers }
        val lottoStore = LottoStore(lottoNumberAutoGenerator)
        val lottos = lottoStore.buyLottos(inputPrice, emptyList())
        val winningNumber = lottoNumberAutoGenerator.takeShuffleNumber()
        val bonusBall = LottoNumber(7)
        val winningLotto = WinningLotto(winningNumber, bonusBall)
        val winningResult = lottos.matchLotto(winningLotto)
        `when`("수익률을 계산한다.") {
            val rateOfReturn = winningResult.calculateRateOfReturn(inputPrice)
            then("수익률은 0.0이상이다.") {
                rateOfReturn shouldBeGreaterThanOrEqual 0.0
            }
        }
    }
})
