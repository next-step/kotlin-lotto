package calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({
    context("calculate()") {
        test("음수 값이 포함되어 있을 경우 RuntimeException 예외가 발생한다.") {
            val actual = shouldThrow<RuntimeException> {
                Calculator.calculate(listOf("-1", "2", "3"))
            }

            actual.message shouldBe "token should be positive number. invalid token: -1"
        }

        test("숫자가 아닌 값이 포함되어 있을 경우 RuntimeException 예외가 발생한다.") {
            val actual = shouldThrow<RuntimeException> {
                Calculator.calculate(listOf("1", "a", "3"))
            }

            actual.message shouldBe "token should be positive number. invalid token: a"
        }
    }
})
