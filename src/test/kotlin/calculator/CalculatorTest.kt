package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({

    test("계산기에 입력받은 문자열이 빈 문자열이거나 null 일 경우 0을 반환한다.") {
        Calculator.calculate(null) shouldBe 0
        Calculator.calculate("") shouldBe 0
    }

    test("계산기에 입력받은 문자열이 “3”일 경우 3을 반환한다.") {
        Calculator.calculate("3") shouldBe 3
    }

    test("계산기에 입력받은 문자열이 “3:5,5”일 경우 13을 반환한다.") {
        Calculator.calculate("3:5,5") shouldBe 13
    }

    test("계산기에 입력받은 문자열이 “//\n3;3”일 경우 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("///\\n3\\n3")
        }
    }

    test("계산기에 입력받은 문자열이 “//;\n3;3”일 경우 6을 반환한다.") {
        Calculator.calculate("//;\n3;3") shouldBe 6
    }

    test("계산기에 입력받은 문자열이 “3:5,a”일 경우 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("3:5,a")
        }
    }

    test("계산기에 입력받은 문자열이 “//;\\n3;a”일 경우 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("//;\\n3;a")
        }
    }

    test("계산기에 입력받은 문자열이 “300:5,5”일 경우 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("300:5,5")
        }
    }

    test("계산기에 입력받은 문자열이 “100:5,5”일 경우 예외를 던진다.") {
        Calculator.calculate("100:5,5") shouldBe 110
    }

    test("계산기에 입력받은 문자열이 “-1:5,5”일 경우 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("-1:5,5")
        }
    }

    test("계산기에 입력받은 문자열이 “0:5,5”일 경우 예외를 던진다.") {
        Calculator.calculate("0:5,5") shouldBe 10
    }

})
