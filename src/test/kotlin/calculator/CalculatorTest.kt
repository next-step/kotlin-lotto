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

    test("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.") {
        Calculator.calculate("1,2") shouldBe 3
    }

    test("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)") {
        Calculator.calculate("1,2:3") shouldBe 6
    }
})
