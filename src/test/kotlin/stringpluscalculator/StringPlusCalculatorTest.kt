package stringpluscalculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringPlusCalculatorTest : BehaviorSpec({

    Given("빈 문자열이나 null이 주어지면") {
        When("문자열 덧셈 계산기는") {
            Then("0을 반환한다.") {
                forAll(
                    row("", 0),
                    row(null, 0)
                ) { input, expected ->
                    StringPlusCalculator.plus(input) shouldBe expected
                }
            }
        }
    }

    Given("구분자를 가지는 문자열이 주어지면") {
        When("문자열 덧셈 계산기는") {
            Then("구분한 결과를 가지고 덧셈을 수행한다.") {
                forAll(
                    row("1,2,3", 6)
                ) { input, expected ->
                    StringPlusCalculator.plus(input) shouldBe expected
                }
            }
        }
    }
})
