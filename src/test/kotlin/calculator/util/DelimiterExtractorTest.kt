package calculator.util

import calculator.const.ExceptionMessage
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

internal class DelimiterExtractorTest : BehaviorSpec({
    Given("//와 \n가 존재하지 않는다면, ") {
        val rawString = "1:2:3"
        When("extract 함수를 호출하면, ") {
            val result = DelimiterExtractor.extract(rawString)
            Then("기본 구분자를 리턴한다.") {
                result.delimiter shouldBe listOf(",", ":")
                result.expression shouldBe "1:2:3"
            }
        }
    }

    Given("//와 \n가 존재하고, ") {
        When("사이에 공백이 아닌 문자가 존재한다면, ") {
            val rawString = "//;\n1;2;3"
            val result = DelimiterExtractor.extract(rawString)
            Then("해당 문자를 포함한 구분자들을 리턴한다.") {
                result.delimiter shouldBe listOf(",", ":", ";")
                result.expression shouldBe "1;2;3"
            }
        }

        When("사이에 존재하는 문자가 빈 문자라면, ") {
            val rawString = "//\n1;2;3"
            Then("예외를 던진다..") {
                val exception = shouldThrow<IllegalArgumentException> {
                    DelimiterExtractor.extract(rawString)
                }
                exception.message shouldBe ExceptionMessage.CUSTOM_DELIMITER_EMPTY_STRING_ERROR
            }
        }
    }
})
