package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class StringCalculatorKoTest : StringSpec({

    "빈 문자열, null 입력 시 0 반환" {
        val calculator = StringCalculator()
        calculator.calculate("") shouldBe 0
        calculator.calculate(null) shouldBe 0
    }
})