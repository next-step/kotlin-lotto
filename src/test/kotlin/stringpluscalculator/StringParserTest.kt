package stringpluscalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.lang.RuntimeException

class StringParserTest : BehaviorSpec({

    Given("구분자가 포함된 문자열이 주어지면") {
        When("문자열 파서는") {
            Then("쉼표(,) 또는 콜론(:)를 기준으로 문자열을 분리하여 리스트를 반환한다.") {
                forAll(
                    row("1,2", listOf("1", "2")),
                    row("1,2:3", listOf("1", "2", "3"))
                ) { input, expected ->
                    StringParser.parser(input) shouldBe expected
                }
            }
        }
    }

    Given("쉼표와 콜론 외에 커스텀 구분자가 포함된 문자열이 주어지면") {
        When("문자열 파서는") {
            Then("구분자를 기준으로 문자열을 분리하여 리스트를 반환한다.") {
                forAll(
                    row("//;\n1;2;3", listOf("1", "2", "3")),
                    row("//;\n1;2,3", listOf("1", "2", "3"))
                ) { input, expected ->
                    StringParser.parser(input) shouldBe expected
                }
            }
        }
    }

    Given("숫자 이외의 값 또는 음수가 주어지면") {
        When("문자열 파서는") {
            Then("예외를 발생한다.") {
                forAll(
                    row("?,2,3"),
                    row("-1,2,3"),
                    row("가,2,3"),
                    row("//;\n가;2,3")
                ) { input ->
                    shouldThrow<RuntimeException> {
                        StringParser.parser(input)
                    }
                }
            }
        }
    }
})
