package calculator

import calculator.parser.TextParser
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAdditionCalculatorTest : StringSpec({
    val textParser = TextParser
    val sut = StringAdditionCalculator(textParser)

    "빈 문자열이나 null을 입력받으면 0을 반환한다" {
        val inputs = listOf("", null)

        inputs.forEach {
            val actual = sut.calculate(it)

            actual shouldBe 0
        }
    }

    "숫자 하나를 입력할 경우 해당 숫자를 반환한다" {
        val input = "1"

        val actual = sut.calculate(input)

        actual shouldBe 1
    }

    "숫자 두개를 쉼표 구분자로 입력할 경우 두 숫자의 합을 반환한다" {
        val input = "1,2"

        val actual = sut.calculate(input)

        actual shouldBe 3
    }

    "쉼표와 콜론 구분자로 숫자 여러개를 입력할 경우 모든 숫자의 합을 반환한다" {
        val input = "12:3,4"

        val actual = sut.calculate(input)

        actual shouldBe 19
    }

    "//와 개행 문자 사이에 커스텀 구분자를 지정할 수 있고, 해당 구분자로 숫자 여러개를 입력할 경우 모든 숫자의 합을 반환한다" {
        val input = "//;\n1;2;3"

        val actual = sut.calculate(input)

        actual shouldBe 6
    }

    "음수를 입력할 경우 IllegalArgumentException을 던진다" {
        val input = "1,-2,3"

        shouldThrow<IllegalArgumentException> {
            sut.calculate(input)
        }
    }
})
