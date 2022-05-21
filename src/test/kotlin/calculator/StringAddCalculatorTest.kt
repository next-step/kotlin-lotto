package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class StringAddCalculatorTest : FreeSpec({
    val calculator = StringAddCalculator()

    "결과값이 0이되는 경우" - {
        listOf(
            "빈 문자열" to "  ",
            "null" to null,
        ).forEach { (name, input) ->
            name {
                calculator.add(input) shouldBe 0
            }
        }
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다" - {
        listOf("1", "5", "9").forEach { input ->
            "$input 을 입력한 경우" {
                calculator.add(input) shouldBe input.toInt()
            }
        }
    }

    "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다" {
        calculator.add("1,2") shouldBe 3
    }

    "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다." {
        calculator.add("1,2:3") shouldBe 6
    }

    "//와 newline 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        calculator.add("//;\n1;2;3") shouldBe 6
    }

    "음수를 전달하는 경우 RuntimeException 예외 처리를 한다." {
        shouldThrow<RuntimeException> {
            calculator.add("-1")
        }
    }
})
