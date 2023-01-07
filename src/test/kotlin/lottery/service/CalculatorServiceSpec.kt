package lottery.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalculatorServiceSpec : BehaviorSpec({

    given("수익률 계산 서비스는") {
        val calculatorService = CalculatorService()

        When("구입 금액과 로또 결과로부터") {
            val amount = 14000L
            val winningResult = mapOf(
                3 to 1,
                4 to 0,
                5 to 0,
                6 to 0
            )

            val rateOfReturn = calculatorService.rateOfReturn(amount, winningResult)

            Then("수익률을 계산하여 반환한다") {
                rateOfReturn shouldBe "0.35"
            }
        }
    }
})
