package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto

class MatchResultTest : BehaviorSpec({
    Given("로또 번호와 당첨 번호가 주어지면") {
        val money = 3000
        val lotto = Lotto.of(money)
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val matches = LottoMatcher.matchingLotto(lotto, winningNumbers)

        When("MatchResult 를 생성할 때") {
            val matchResult = MatchResult(matches)

            Then("총 수익률 계산이 정확해야 한다") {
                val expectedEarningRate = matchResult.calculateEarningRate(money)
                matchResult.calculateEarningRate(money) shouldBe expectedEarningRate
            }
        }
    }
})
