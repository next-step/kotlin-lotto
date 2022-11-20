package calculator.extension

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class StringExtensionKtTest : BehaviorSpec({
    Given("문자열이 ") {
        When("숫자로만 이루어져 있다면") {
            val number = "1234"
            Then("성공한다.") {
                number.isPositiveNumeric() shouldBe true
            }
        }

        When("숫자로만 이루어져 있지 않다면") {
            val number = "1234fff"
            Then("실패한다.") {
                number.isPositiveNumeric() shouldBe false
            }
        }
    }
})
