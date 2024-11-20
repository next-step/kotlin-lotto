package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly

class ConverterTest : BehaviorSpec({
    val converter = Converter()

    Given("문자열 리스트를 숫자 리스트로 변환하는 기능이 있을 때") {
        When("문자열 리스트에 숫자만 포함되어 있다면") {
            val result = converter.toNumbers(listOf("1", "2", "3"))
            Then("숫자 리스트로 변환해야 한다") {
                result shouldContainExactly listOf(1, 2, 3)
            }
        }

        When("문자열 리스트에 숫자가 아닌 값이 포함되어 있다면") {
            Then("예외를 던져야 한다") {
                shouldThrow<IllegalStateException> {
                    converter.toNumbers(listOf("1", "a", "3"))
                }
            }
        }

        When("문자열 리스트가 비어 있다면") {
            val result = converter.toNumbers(emptyList())
            Then("빈 숫자 리스트를 반환해야 한다") {
                result shouldContainExactly emptyList()
            }
        }
    }
})
