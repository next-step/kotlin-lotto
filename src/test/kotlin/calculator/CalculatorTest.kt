package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CalculatorTest : BehaviorSpec({
    Given("입력 값에 ") {
        When("널 값이 들어오면 ") {
            val rawString = null
            val result = Calculator.calculate(rawString)
            Then("0을 출력한다.") {
                result shouldBe 0
            }
        }

        When("빈 문자열이 들어오면 ") {
            val rawString = ""
            val result = Calculator.calculate(rawString)
            Then("0을 출력한다.") {
                result shouldBe 0
            }
        }

        When("정상적인 값이 들어오면 ") {
            val rawString = "1,2,3"
            val result = Calculator.calculate(rawString)
            Then("정상적으로 출력한다.") {
                result shouldBe 6
            }

            val rawStringWithCustomDelimiter = "//;\n1;2;3"
            val resultWithCustomDelimiter = Calculator.calculate(rawStringWithCustomDelimiter)
            Then("정상적으로 출력한다.") {
                resultWithCustomDelimiter shouldBe 6
            }
        }
    }
})
