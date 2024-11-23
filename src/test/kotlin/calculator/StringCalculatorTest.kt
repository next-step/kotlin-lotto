package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    val sut = StringCalculator()

    "쉼표로 구분되는 숫자들을 더한다." {
        val expression = "1,2,3"

        val actual = sut.calculate(expression)

        actual shouldBe 6.0
    }

    "콜론으로 구분되는 숫자들을 더한다." {
        val expression = "1:2:3"

        val actual = sut.calculate(expression)

        actual shouldBe 6.0
    }

    "쉼표와 콜론으로 구분되는 숫자들을 더한다." {
        val expression = "1,2:3"

        val actual = sut.calculate(expression)

        actual shouldBe 6.0
    }

    "커스텀 구분자로 구분되는 숫자들을 더한다." {
        val expression = "//;\n1;2;3"

        val actual = sut.calculate(expression)

        actual shouldBe 6.0
    }

    "빈 문자열을 전달하는 경우 예외를 던진다." {
        shouldThrow<RuntimeException> {
            sut.calculate("")
        }
    }

    "유효하지 않은 숫자를 입력하는 경우 예외를 던진다." {
        shouldThrow<RuntimeException> {
            sut.calculate("1a2b3c")
        }
    }

    "음수를 입력하는 경우 예외를 던진다." {
        shouldThrow<RuntimeException> {
            sut.calculate("-1,-2:-3")
        }
    }
})
