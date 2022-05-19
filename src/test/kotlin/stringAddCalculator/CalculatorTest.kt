package stringAddCalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FreeSpec({

    "calculate" - {

        "null일 경우 0를 반환해야한다." {
            val input = null
            Calculator.calculate(input) shouldBe 0
        }

        "blank로 이루어진 문자열일 경우 0을 반환해야한다." {
            val input = "  "
            Calculator.calculate(input) shouldBe 0
        }

        "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
            val input = "2"
            Calculator.calculate(input) shouldBe 2
        }
    }

    "splitString" - {

        ", 을 기준으로 문자열이 분리되어야한다." {
            val inputString = "1,2"
            Calculator.splitString(inputString) shouldBe listOf("1", "2")
        }

        ": 을 기준으로 문자열이 분리되어야한다." {
            val inputString = "1:2"
            Calculator.splitString(inputString) shouldBe listOf("1", "2")
        }
    }

    "findDelimiter" - {

        "`//`와 `\n` 문자 사이에 커스텀 구분자를 기준으로 문자열이 분리되어야한다.." {
            val customString = "//;\n1;2;3"
            Calculator.customDelimiter(customString) shouldBe listOf("1", "2", "3")
        }
    }

    "convertInt" - {

        "분리된 문자열이 숫자로 변환되어야한다." {
            val splitList = listOf("1", "2")
            Calculator.convertInt(splitList) shouldBe listOf(1, 2)
        }
    }

    "add" - {

        "숫자 리스트의 모든 수의 합을 반환한다." {
            val numberList = listOf(1, 2, 3)
            Calculator.add(numberList) shouldBe 6
        }
    }

    "checkNegative" - {

        "분리된 문자열에 음수가 존재하면 RuntimeException" {
            val numberList = listOf(1, -2, 3)
            val exception = shouldThrow<RuntimeException> {
                Calculator.checkNegative(numberList)
            }
            exception.message shouldBe Calculator.NEGATIVE_ERROR
        }
    }
})
