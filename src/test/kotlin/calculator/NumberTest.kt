package calculator

import calculator.Number
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll

class NumberTest : BehaviorSpec({

    Given("음수가") {
        val num = "-1"
        When("전달되면") {
            Then("RuntimeException 예외가 발생한다.") {
                shouldThrow<RuntimeException> {
                    Number.of(num)
                }
            }
        }
    }

    Given("숫자 이외의 값이") {
        val nums = listOf("*", "!", "a")
        When("전달되면") {
            Then("RuntimeException 예외가 발생한다.") {
                nums.forAll { num ->
                    shouldThrow<RuntimeException> {
                        Number.of(num)
                    }
                }
            }
        }
    }
})
