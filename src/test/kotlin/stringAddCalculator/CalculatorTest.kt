package stringAddCalculator

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FreeSpec({

    "calculate" - {

        "null일 경우 0를 반환해야한다." {
            val input = null
            Calculator.calculate(input) shouldBe 0
        }

        "blank로 이루어진 문자열일 경우 0을 반황해야한다." {
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
    }

    "convertInt" - {

        "분리된 문자열이 숫자로 변환되어야한다." {
            val splitList = listOf("1", "2")
            Calculator.convertInt(splitList) shouldBe listOf(1, 2)
        }
    }
})
