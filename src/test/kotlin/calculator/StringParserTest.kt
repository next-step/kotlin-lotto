package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class StringParserTest : BehaviorSpec({
    val parser = StringParser()

    Given("문자열 파서를 사용할 때") {
        listOf(
            Triple("1,2,3", listOf("1", "2", "3"), "쉼표로 구분된 문자열"),
            Triple("1:2:3", listOf("1", "2", "3"), "콜론으로 구분된 문자열"),
            Triple("1,2:3", listOf("1", "2", "3"), "쉼표와 콜론이 혼합된 문자열"),
            Triple("//;\n1;2;3", listOf("1", "2", "3"), "커스텀 구분자로 구분된 문자열"),
            Triple("", emptyList<String>(), "빈 문자열"),
        ).forEach { (input, expected, description) ->
            When(description) {
                val result = parser.split(input)
                Then("문자열을 숫자 리스트로 분리해야 한다") {
                    if (expected.isEmpty()) {
                        result.shouldBeEmpty()
                    } else {
                        result shouldContainExactly expected
                    }
                }
            }
        }
    }
    Given("문자열에 커스텀 구분자를 추출할 때") {
        When("문자열이 //;\n1;2;3 형식인 경우") {
            val result = parser.extractCustomSeparator("//;\n1;2;3")
            Then("커스텀 구분자 ';'를 반환해야 한다") {
                result shouldBe ";"
            }
        }

        When("문자열이 기본 구분자만 포함된 경우") {
            val result = parser.extractCustomSeparator("1,2:3")
            Then("null을 반환해야 한다") {
                result shouldBe null
            }
        }
    }
    Given("커스텀 구분자 제외할 때") {
        When("문자열이 //;\n1;2;3 형식인 경우") {
            val result = parser.removeCustomSeparatorHeader("//;\n1;2;3", ";")
            Then("헤더 '//;\n'를 제거한 문자열을 반환해야 한다") {
                result shouldBe "1;2;3"
            }
        }

        When("문자열이 기본 구분자만 포함된 경우") {
            val result = parser.removeCustomSeparatorHeader("1,2:3", null)
            Then("문자열을 그대로 반환해야 한다") {
                result shouldBe "1,2:3"
            }
        }
    }
    Given("문자열을 특정 구분자로 분리할 때") {
        When("문자열이 기본 구분자 쉼표와 콜론을 포함하는 경우") {
            val result = parser.splitContent("1,2:3", null)
            Then("기본 구분자로 문자열을 분리해야 한다") {
                result shouldContainExactly listOf("1", "2", "3")
            }
        }

        When("문자열이 커스텀 구분자로 구분된 경우") {
            val result = parser.splitContent("1;2;3", ";")
            Then("커스텀 구분자를 기준으로 문자열을 분리해야 한다") {
                result shouldContainExactly listOf("1", "2", "3")
            }
        }
    }
})
