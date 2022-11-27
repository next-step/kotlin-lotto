package calculator

import calculator.domain.Separator
import calculator.domain.StringAdder
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringAdderTest : StringSpec({
    "수식을 계산한 결과를 반환해요" {
        forAll(
            row("1", 1),
            row("1,2:3", 6),
            row("//;\n1;2;3", 6)
        ) { expression, result: Long ->
            val calculator = StringAdder(
                separator = Separator()
            )

            calculator.calculate(expression) shouldBe result
        }
    }

    "수식이 빈 문자열이면 0을 반환해요" {
        forAll(
            row("", 0),
            row("//;\n", 0),
        ) { expression, result: Long ->
            val calculator = StringAdder(
                separator = Separator()
            )

            calculator.calculate(expression) shouldBe result
        }
    }
})
