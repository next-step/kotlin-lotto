package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual

class WinningRanksTest : BehaviorSpec({

    val testShuffleNumber: ShuffleNumber = object : ShuffleNumber {
        override fun shuffleNumber(numbers: List<LottoNumber>): List<LottoNumber> {
            return numbers.sortedBy { it.number }
        }
    }
    val lottoNumberGenerator = LottoNumberGenerator(testShuffleNumber)

    given("입력금액이 주어졌을 때") {
        val inputPrice = 14000
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) }
        val lottos = LottoStore.buyLottos(inputPrice, emptyList())
        val winningNumber = lottoNumberGenerator.takeShuffleNumber(lottoNumbers, Lotto.LOTTO_NUMBER_SIZE)
        val bonusBall = lottoNumbers.last()
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
