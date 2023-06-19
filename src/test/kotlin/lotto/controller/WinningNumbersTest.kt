package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.Prize
import lotto.domain.numberGenerator.FixedNumberGenerator

class WinningNumbersTest : BehaviorSpec({

    Given("당첨 번호와 로또 번호들이 주어지면") {
        val winningNumbersData = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lottoNumbersData = listOf(
            listOf(1, 2, 3, 7, 8, 9),
            listOf(1, 2, 3, 4, 5, 6),
            listOf(10, 11, 12, 13, 14, 15),
            listOf(1, 2, 3, 4, 5, 7)
        )
        val winningNumbers = WinningNumbers.of(LottoNumbers(FixedNumberGenerator(winningNumbersData)), bonusNumber)
        val lottoNumbersList = lottoNumbersData.map { LottoNumbers(FixedNumberGenerator(it)) }

        When("일치하는 번호 개수를 세고 MatchResult 를 계산할 때") {
            val matchResult = winningNumbers.calculateMatchResult(Lottos(lottoNumbersList))

            Then("MatchResult 의 결과가 정확해야 한다") {
                matchResult.getNumberOfMatchesForPrize(Prize.FIRST) shouldBe 1
                matchResult.getNumberOfMatchesForPrize(Prize.SECOND) shouldBe 1
                matchResult.getNumberOfMatchesForPrize(Prize.THIRD) shouldBe 0
                matchResult.getNumberOfMatchesForPrize(Prize.FOURTH) shouldBe 0
                matchResult.getNumberOfMatchesForPrize(Prize.FIFTH) shouldBe 1
                matchResult.getNumberOfMatchesForPrize(Prize.NO_PRIZE) shouldBe 1
            }
        }
    }
})
