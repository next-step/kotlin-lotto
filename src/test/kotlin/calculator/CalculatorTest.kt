package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({

    test("빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다") {
        calculate("") shouldBe 0
        calculate(null) shouldBe 0
    }

    test("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.") {
        calculate("1") shouldBe 1
    }

    test("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.") {
        calculate("1,2") shouldBe 3
    }

    test("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)") {
        calculate("1,2:3") shouldBe 6
    }

    test("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)") {
        calculate("//;\n1;2;3") shouldBe 6
    }

    test("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.") {
        shouldThrow<java.lang.RuntimeException> {
            calculate("-1,2,3")
        }
    }
})
