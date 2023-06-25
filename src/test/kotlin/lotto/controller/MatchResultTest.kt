package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.Prize
import lotto.domain.numberGenerator.FixedLottoNumberGenerator

class MatchResultTest : BehaviorSpec({
    Given("로또 번호와 당첨 번호가 주어지면") {
        val money = 3000
        val bonusNumber = 7
        val winningNumbers = WinningNumbers(
            LottoNumbers(FixedLottoNumberGenerator(listOf(1, 2, 3, 4, 5, 6)).generateNumbers()),
            LottoNumber(bonusNumber)
        )
        val lottoNumbersData = listOf(
            listOf(1, 2, 3, 7, 8, 9), // 5등
            listOf(1, 2, 3, 4, 5, 6), // 1등
            listOf(10, 11, 12, 13, 14, 15), // 미당첨
            listOf(1, 2, 3, 4, 5, 7) // 2등
        )
        val lottoNumbersList = lottoNumbersData.map { LottoNumbers(FixedLottoNumberGenerator(it).generateNumbers()) }
        val lottos = Lottos(lottoNumbersList)

        When("MatchResult 를 생성할 때") {
            val matchResult = winningNumbers.calculateMatchResult(lottos)

            Then("총 수익률 계산이 정확해야 한다") {
                val expectedEarningRate =
                    (Prize.SECOND.amount + Prize.FIRST.amount + Prize.FIFTH.amount).toDouble() / money
                matchResult.calculateEarningRate(money) shouldBe (expectedEarningRate plusOrMinus 600.0)
            }

            Then("특정 상에 대한 일치 횟수를 가져올 수 있어야 한다") {
                matchResult.getNumberOfMatchesForPrize(Prize.FIRST) shouldBe 1
                matchResult.getNumberOfMatchesForPrize(Prize.SECOND) shouldBe 1
                matchResult.getNumberOfMatchesForPrize(Prize.FIFTH) shouldBe 1
                matchResult.getNumberOfMatchesForPrize(Prize.NO_PRIZE) shouldBe 1
            }

            Then("이익 여부를 판별할 수 있어야 한다") {
                val isProfitable = matchResult.calculateEarningRate(money) >= 1.0
                matchResult.isProfit(money) shouldBe isProfitable
            }
        }
    }
})
