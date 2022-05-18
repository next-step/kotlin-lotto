package stringAddCalculator

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FreeSpec({

    "calculate" - {

        "null일 경우 0를 반환해야한다." {
            val input = null
            Calculator.calculate(input) shouldBe 0
        }

        "black로 이루어진 문자열일 경우 0을 반황해야한다." {
            val input = "  "
            Calculator.calculate(input) shouldBe 0
        }
    }
})
