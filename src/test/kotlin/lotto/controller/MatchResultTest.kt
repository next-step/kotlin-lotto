package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.Prize
import lotto.domain.numberGenerator.FixedNumberGenerator

class MatchResultTest : BehaviorSpec({
    Given("로또 번호와 당첨 번호가 주어지면") {
        val money = 3000
        val bonusNumber = 7
        val winningNumbers = WinningNumbers(LottoNumbers(FixedNumberGenerator(listOf(1, 2, 3, 4, 5, 6))), bonusNumber)

        val lottoNumbersData = listOf(
            listOf(1, 2, 3, 7, 8, 9),
            listOf(1, 2, 3, 4, 5, 6),
            listOf(10, 11, 12, 13, 14, 15),
            listOf(1, 2, 3, 4, 5, 7)
        )
        val lottoNumbersList = lottoNumbersData.map { LottoNumbers(FixedNumberGenerator(it)) }
        val lottos = Lottos(lottoNumbersList)

        When("MatchResult 를 생성할 때") {
            val matchResult = winningNumbers.calculateMatchResult(lottos)

            Then("총 수익률 계산이 정확해야 한다") {
                val expectedEarningRate = (Prize.SECOND.amount + Prize.FIRST.amount + Prize.THIRD.amount).toDouble() / money
                matchResult.calculateEarningRate(money) shouldBe (expectedEarningRate plusOrMinus 600.0)
            }

            Then("특정 상에 대한 일치 횟수를 가져올 수 있어야 한다") {
                matchResult.getNumberOfMatchesForPrize(Prize.FIRST) shouldBe 1
                matchResult.getNumberOfMatchesForPrize(Prize.SECOND) shouldBe 1
                matchResult.getNumberOfMatchesForPrize(Prize.THIRD) shouldBe 0
                matchResult.getNumberOfMatchesForPrize(Prize.FOURTH) shouldBe 0
                matchResult.getNumberOfMatchesForPrize(Prize.FIFTH) shouldBe 1
                matchResult.getNumberOfMatchesForPrize(Prize.NO_PRIZE) shouldBe 1
            }

            Then("이익 여부를 판별할 수 있어야 한다") {
                val isProfit = matchResult.calculateEarningRate(money) >= 1
                matchResult.isProfit(money) shouldBe isProfit
            }
        }
    }
})
