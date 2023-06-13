package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({

    "문자열을 입력하면 쉼표와 콜론을 기준으로 숫자를 분리한다" {
        val input = "1,2"
        val calculator = StringAddCalculator(input)
        val result = calculator.separateStrings()
        result shouldBe listOf(1, 2)
    }
})
