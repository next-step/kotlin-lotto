package stringAddCalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CalculatorTest : FreeSpec({

    "calculate" - {

        "입력값이 유효한 경우 덧셈이 되는 동작 확인" {
            withData(
                "1" to 1,
                "" to 0,
                "1:2,3" to 6,
                "//!\n2!3" to 5,
            ) { (input, output) ->
                Calculator.calculate(input) shouldBe output
            }
        }
    }

    "getInputOrDefault" - {

        "null일 경우 0를 반환해야한다." {
            val input = null
            Calculator.getInputOrDefault(input) shouldBe "0"
        }

        "blank로 이루어진 문자열일 경우 0을 반환해야한다." {
            val input = "  "
            Calculator.getInputOrDefault(input) shouldBe "0"
        }
    }

    "splitByDefaultDelimiter" - {

        ", 을 기준으로 문자열이 분리되어야한다." {
            val inputString = "1,2"
            Calculator.splitByDefaultDelimiter(inputString) shouldBe listOf("1", "2")
        }

        ": 을 기준으로 문자열이 분리되어야한다." {
            val inputString = "1:2"
            Calculator.splitByDefaultDelimiter(inputString) shouldBe listOf("1", "2")
        }

        ",와 : 을 기준으로 문자열이 분리되어야한다." {
            val inputString = "1,2:3"
            Calculator.splitByDefaultDelimiter(inputString) shouldBe listOf("1", "2", "3")
        }

        "단일 문자여도 리스로 반환되어야한다." {
            val inputString = "1"
            Calculator.splitByDefaultDelimiter(inputString) shouldBe listOf(inputString)
        }
    }

    "customDelimiter" - {

        "`//`와 `\n` 문자 사이에 커스텀 구분자를 기준으로 문자열이 분리되어야한다.." {
            val customString = "//;\n1;2;3"
            Calculator.splitCustomDelimiter(customString) shouldBe listOf("1", "2", "3")
        }
    }

    "convertOperand" - {

        "분리된 문자열이 숫자로 변환되어야한다." {
            val splitList = listOf("1", "2")
            Calculator.convertOperand(splitList) shouldBe listOf(1, 2)
        }
    }

    "accumulateSum" - {

        "숫자 리스트의 모든 수의 합을 반환한다." {
            val numberList = listOf(1, 2, 3)
            Calculator.accumulateSum(numberList) shouldBe 6
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
