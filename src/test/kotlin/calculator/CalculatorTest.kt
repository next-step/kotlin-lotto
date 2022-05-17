package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({

    test("빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다") {
        Calculator.calculate("") shouldBe 0
        Calculator.calculate(null) shouldBe 0
    }
})
