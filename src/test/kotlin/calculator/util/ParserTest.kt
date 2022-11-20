package calculator.util

import calculator.const.ExceptionMessage
import calculator.const.IllegalExpressionException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class ParserTest : BehaviorSpec({
    Given("정상적인 입력이 들어온다면, ") {
        When("파싱을 진행할 때, ") {
            val delimiters = listOf(",", ":")
            val expression = "1,2,3"
            val result = Parser.parse(delimiters, expression)
            Then("성공한다.") {
                result shouldBe listOf(1, 2, 3)
            }
        }
    }

    Given("입력이 들어올 때,") {
        When("입력에 포함된 구분자가 토큰에 없는 경우일 때, ") {
            val delimiters = listOf(",", ":")
            val expression = "1;2;3"
            Then("예외를 발생한다.") {
                val exception = shouldThrow<IllegalExpressionException> {
                    Parser.parse(delimiters, expression)
                }
                exception.message shouldBe ExceptionMessage.ILLEGAL_EXPRESSION_ERROR
            }
        }

        When("음수가 들어온다면, ") {
            val delimiters = listOf(",", ":")
            val expression = "1:2:-1"
            Then("예외를 발생한다.") {
                val exception = shouldThrow<IllegalExpressionException> {
                    Parser.parse(delimiters, expression)
                }
                exception.message shouldBe ExceptionMessage.ILLEGAL_EXPRESSION_ERROR
            }
        }

        When("숫자가 아닌 문자가 들어온다면, ") {
            val delimiters = listOf(",", ":")
            val expression = "1:2:c"
            Then("예외를 발생한다.") {
                val exception = shouldThrow<IllegalExpressionException> {
                    Parser.parse(delimiters, expression)
                }
                exception.message shouldBe ExceptionMessage.ILLEGAL_EXPRESSION_ERROR
            }
        }
    }
})
