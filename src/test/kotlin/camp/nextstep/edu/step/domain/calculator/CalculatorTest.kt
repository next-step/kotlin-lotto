package camp.nextstep.edu.step.domain.calculator

import camp.nextstep.edu.step.domain.amount.FinalResult
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec({

    Given("특수문자가 구분된 숫자들 리스트가 주어지고") {
        val numbers = listOf("1", "2", "3")

        When("계산기에 숫자 리스트를 넣으면") {
            val calculator = Calculator.of(expressions = numbers)
            val result = calculator.calculateExpression()

            Then("숫자들의 합을 반환한다.") {
                result shouldBe FinalResult(amount = 6)
            }
        }
    }

})
