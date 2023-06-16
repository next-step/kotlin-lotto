package stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import stringcalculator.parser.RegexExpressionParser

class StringCalculatorTest : StringSpec({
    lateinit var calculator: StringCalculator
    beforeEach {
        calculator = StringCalculator(RegexExpressionParser)
    }

    "빈 문자열을 입력할 경우 0을 반환해야 한다." {
        listOf(
            " " to 0,
            "" to 0
        )
            .forEach { (operand, result) ->
                calculator.add(operand) shouldBe Operand(result)
            }
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        listOf(
            "1" to 1,
            "10" to 10
        )
            .forEach { (operand, result) ->
                calculator.add(operand) shouldBe Operand(result)
            }
    }

    "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        calculator.add("12,13") shouldBe Operand(25)
    }

    "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다." {
        calculator.add("12:13") shouldBe Operand(25)
    }

    "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        calculator.add("""//;\n1;2;3""") shouldBe Operand(6)
    }

    "문자열 계산기에 음수를 전달하는 경우 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            calculator.add("-1")
        }
    }
})
