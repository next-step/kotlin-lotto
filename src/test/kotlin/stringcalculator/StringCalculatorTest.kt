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
            row("//:\n1::2"),
            row("//?\n1?2;3:4"),
        ) { input ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> {
                    StringCalculator("//;\n1;::2")
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
            row(";//;\n1;2;3"),
        ) { input ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> {
                    StringCalculator(input)
                }
            exception.message shouldBe "입력 형식이 올바르지 않습니다."
        }
    }
})
