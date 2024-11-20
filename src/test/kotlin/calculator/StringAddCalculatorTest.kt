package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : BehaviorSpec({
    Given("숫자 리스트의 합계를 계산하는 기능이 있을 때") {
        When("숫자 리스트가 비어 있다면") {
            val result = StringAddCalculator("").add()
            Then("0을 반환해야 한다") {
                result shouldBe 0
            }
        }

        When("양수로만 이루어진 리스트가 주어지면") {
            val result = StringAddCalculator("1,2,3").add()
            Then("리스트의 합계를 반환해야 한다") {
                result shouldBe 6
            }
        }

        When("커스텀 구분자로 구분된 문자열이 주어지면") {
            val result = StringAddCalculator("//_\n1_2_3").add()
            Then("리스트의 합계를 반환해야 한다") {
                result shouldBe 6
            }
        }
    }
})
