package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec({

    Given("수식이") {
        val textAndExpected = listOf(
            "1,2" to 3,
            "1,2:3" to 6,
            "//;\n1;2;3" to 6
        )
        When("문자열 계산기에 입력되면") {
            textAndExpected.forAll { (text, expected) ->
                val result = Calculator.calculate(text)
                Then("숫자의 합이 반환된다.") {
                    result shouldBe expected
                }
            }
        }
    }
})
