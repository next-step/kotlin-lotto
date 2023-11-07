package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    val inputParser = InputParser()
    val operator = Operator()
    val stringCalculator = StringCalculator(inputParser = inputParser, operator = operator)

    "계산기에 빈 문자열이 오면 0 을 반환한다." {
        val expression = ""

        val result = stringCalculator.add(expression)

        result shouldBe 0
    }

    "계산기는 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        val expressions = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")

        expressions.forAll {
            val result = stringCalculator.add(it)

            result shouldBe it.toInt()
        }
    }

    "계산기는 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        val expression = "2,3"

        val result = stringCalculator.add(expression)

        result shouldBe 5
    }


    "계산기는 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다." {
        val expression = "3:4"

        val result = stringCalculator.add(expression)

        result shouldBe 7
    }

    "계산기는 문자 사이에 커스텀 구분자를 지정할 수 있다" {
        val expression = "//;\n1;2;3"

        val result = stringCalculator.add(expression)

        result shouldBe 6
    }

    "계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다" {
        val expression = "-1,3,4"

        shouldThrow<RuntimeException> {
            stringCalculator.add(expression)
        }
    }
})
