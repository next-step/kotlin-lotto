package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    "유효하지 않은 구분자가 포함되어 있으면 예외 처리한다." {
        forAll(
            row("1:2"),
            row("//:\\n1::2"),
            row("//?\\n1?2;3:4"),
        ) { input ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> {
                    StringCalculator.calculate("//;\n1;::2")
                }
            exception.message shouldBe "입력에 유효하지 않은 구분자가 포함되어 있습니다."
        }
    }

    "입력 형식이 올바르지 않으면 예외 처리한다." {
        forAll(
            row("1,2,3,"),
            row(",1,2,3"),
            row("1,2,3,"),
            row(":1:2:3"),
            row(";//;\\n1;2;3"),
        ) { input ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> {
                    StringCalculator.calculate(input)
                }
            exception.message shouldBe "입력 형식이 올바르지 않습니다."
        }
    }

    "입력이 빈 문자열일 경우 0을 반환한다." {
        val actual = StringCalculator.calculate("")
        actual shouldBe 0
    }

    "분리된 숫자와 연산자를 통해 계산을 수행할 수 있다." {
        forAll(
            row("1,2,3", 6),
            row("1:2:3:4:5", 15),
            row("//;\\n1,2;3:4", 10),
        ) { input, expected ->

            val actual = StringCalculator.calculate(input)
            actual shouldBe expected
        }
    }

    "숫자 하나를 입력받은 경우 해당 숫자를 반환한다." {
        forAll(
            row("1"),
            row("2"),
            row("10"),
            row("5000"),
        ) { input ->
            val actual = StringCalculator.calculate(input)
            actual shouldBe input.toInt()
        }
    }
})
