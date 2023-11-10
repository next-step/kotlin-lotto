package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ProfitCalculatorTest : BehaviorSpec({
    Given(
        "번호 일치 결과가 1개 일치: 1개 / 4개 일치: 1개"
    ) {
        val lottoResults = LottoResults(
            listOf(0, 1, 0, 0, 1, 0, 0)
        )
        When("계산 했을 때") {
            val profit = ProfitCalculator.calculate(lottoResults)
            Then("수익률은 2.5이다") {
                profit shouldBe 2.5
            }
        }
    }
})
