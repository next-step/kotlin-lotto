package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ConverterTest : BehaviorSpec({
    val converter = Converter()

    Given("문자열을 숫자로 변환할 때") {
        When("숫자인 문자열이라면") {
            val result = converter.toPositiveNumber("1")
            Then("숫자로 변환해야 한다") {
                result shouldBe 1
            }
        }

        When("문자열에 숫자가 아닌 값이라면") {
            listOf("a", "-1").forEach { input ->
                Then("예외를 던져야 한다") {
                    shouldThrow<IllegalStateException> {
                        converter.toPositiveNumber(input)
                    }
                }
            }
        }
    }
})
