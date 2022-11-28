package stringcalculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec({
    given("기본 구분자로 구분된 문자열을 입력한다.") {
        val expressionString = "10,1:2"
        val expectedResult = 13
        val calculator = Calculator.from(expressionString)
        `when`("문자열을 계산한다.") {
            val result = calculator.calculate()
            then("기댓값을 반환한다.") {
                result shouldBe expectedResult
            }
        }
    }

    given("기본 구분자와 커스텀 구분자로 구분된 문자열을 입력한다.") {
        val expressionString = "//;\n10,1;2:3"
        val expectedResult = 16
        val calculator = Calculator.from(expressionString)
        `when`("문자열을 계산한다.") {
            val result = calculator.calculate()
            then("기댓값을 반환한다.") {
                result shouldBe expectedResult
            }
        }
    }

    given("null을 입력한다.") {
        val expressionString = null
        val calculator = Calculator.from(expressionString)
        `when`("계산하면") {
            val result = calculator.calculate()
            then("0을 반환한다.") {
                result shouldBe 0
            }
        }
    }
})
