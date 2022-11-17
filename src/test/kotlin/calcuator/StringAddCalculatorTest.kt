package calcuator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeZero
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({
    isolationMode = IsolationMode.InstancePerTest

    val calculator = StringAddCalculator()

    "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다." {
        forAll(
            row(""),
            row(" "),
            row(null),
        ) { text ->
            calculator.add(text).shouldBeZero()
        }
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        forAll(
            row("1"),
            row("10"),
        ) { text ->
            calculator.add(text) shouldBe text.toInt()
        }
    }

    "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다." {
        forAll(
            row("-1")
        ) { text ->
            shouldThrow<RuntimeException> {
                calculator.add(text)
            }
        }
    }

    "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
    }

    "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다." {
    }

    "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다." {
    }
})
