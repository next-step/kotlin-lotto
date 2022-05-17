package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({

    test("빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다") {
        Calculator.calculate("") shouldBe 0
        Calculator.calculate(null) shouldBe 0
    }

    test("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.") {
        Calculator.calculate("1") shouldBe 1
    }
})
