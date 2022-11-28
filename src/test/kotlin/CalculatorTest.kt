import calculator.Calculator
import calculator.Number
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec({

    val texts = listOf(
        "1,2" to 3,
        "1,2:3" to 6,
        "//;\n1;2;3" to 6
    )
    Given("수식이") {
        When("문자열 계산기에 입력되면") {
            Then("숫자의 합이 반환된다.") {
                texts.forAll { (text, result) ->
                    Calculator.calculate(text) shouldBe result
                }
            }
        }
    }
})