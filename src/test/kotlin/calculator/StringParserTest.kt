package calculator
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly

class StringParserTest : BehaviorSpec({
    val parser = StringParser()

    Given("문자열 파서를 사용할 때") {
        When("입력 문자열이 쉼표로 구분되어 있다면") {
            val result = parser.split("1,2,3")
            Then("문자열을 숫자 리스트로 분리해야 한다") {
                result shouldContainExactly listOf("1", "2", "3")
            }
        }

        When("입력 문자열이 콜론으로 구분되어 있다면") {
            val result = parser.split("1:2:3")
            Then("문자열을 숫자 리스트로 분리해야 한다") {
                result shouldContainExactly listOf("1", "2", "3")
            }
        }

        When("입력 문자열이 쉼표와 콜론으로 혼합되어 있다면") {
            val result = parser.split("1,2:3")
            Then("문자열을 숫자 리스트로 분리해야 한다") {
                result shouldContainExactly listOf("1", "2", "3")
            }
        }

        When("입력 문자열이 비어 있다면") {
            val result = parser.split("")
            then("빈 리스트를 반환해야 한다") {
                result.shouldBeEmpty()
            }
        }
    }
})
