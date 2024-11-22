package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
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
    Given("문자열에서 커스텀 구분자와 본문을 추출할 때") {
        When("문자열에 커스텀 구분자가 들어간 형식인 경우") {
            val (content, customSeparator) = parser.extractCustomSeparatorAndContent("//;\n1;2;3")
            Then("커스텀 구분자와 본문을 반환해야 한다") {
                content shouldBe "1;2;3"
                customSeparator shouldBe ";"
            }
        }

        When("문자열이 기본 구분자만 포함된 경우") {
            val (content, customSeparator) = parser.extractCustomSeparatorAndContent("1,2:3")
            Then("기본 구분자와 원본 문자열을 반환해야 한다") {
                content shouldBe "1,2:3"
                customSeparator shouldBe "[,:]"
            }
        }
    }

    Given("문자열을 구분자로 분리할 때") {
        When("문자열이 기본 구분자를 포함한 경우") {
            val result = parser.splitContent("1,2:3")
            Then("쉼표와 콜론을 기준으로 분리한 리스트를 반환해야 한다") {
                result shouldBe listOf("1", "2", "3")
            }
        }

        When("문자열이 커스텀 구분자를 포함한 경우") {
            val result = parser.splitContent("1;2;3", ";")
            Then("커스텀 구분자 ';'를 기준으로 분리한 리스트를 반환해야 한다") {
                result shouldBe listOf("1", "2", "3")
            }
        }

        forAll(
            row("1 2 3"),
            row(""),
        ) {
            When("문자열에 공백이 포함된 경우") {
                Then("예외가 발생해야 한다") {
                    val exception =
                        shouldThrow<IllegalArgumentException> {
                            parser.splitContent(it)
                        }
                    exception.message shouldBe "입력값이 비어있거나 공백이 포함되어 있습니다."
                }
            }
        }
    }
})
