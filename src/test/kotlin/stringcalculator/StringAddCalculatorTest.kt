package stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({
    val calculator = StringAddCalculator()
    "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다." {
        calculator.calculate("") shouldBe 0
        calculator.calculate(null) shouldBe 0
    }
    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        listOf("1", "2").forAll {
            calculator.calculate(it) shouldBe it.toInt()
        }
    }
    "숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예 : “1,2”)" {
        calculator.calculate("1,2") shouldBe 3
    }
    "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다." {
        shouldThrow<RuntimeException> { calculator.calculate("-1") }
    }
    "\"//와 \\\\n 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        calculator.calculate("//;\n1;2;3") shouldBe 6
    }
    "새롭게 추가한 구분자와 기존의 구분자를 혼합해서 계산을 할 수 있다" {
        calculator.calculate("//;\n1;2,3:4") shouldBe 10
    }
    "식 중간에 음수가 들어오면 계산도중 RuntimeException 발생한다" {
        listOf(
            "3,4,-1",
            "//;\n3,4;-1"
        ).forAll {
            shouldThrow<RuntimeException> {
                calculator.calculate(it)
            }
        }
    }
})
