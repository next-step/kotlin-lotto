package stringpluscalculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringPlusCalculatorTest : BehaviorSpec({

    Given("문자열 덧셈 계산기는") {
        When("빈 문자열이나 null을 입력받으면") {
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
})
