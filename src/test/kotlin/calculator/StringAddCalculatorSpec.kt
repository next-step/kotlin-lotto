package calculator

import calcuator.StringAddCalculator
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringAddCalculatorSpec : FunSpec({
    test("빈 문자열 또는 null이 들어오면 0을 반환한다") {
        forAll(
            row(""),
            row(null),
        ) { input ->

            val result = StringAddCalculator.add(input)

            result shouldBe 0
        }
    }

    test("주어진 문자열의 합을 계산한다") {
        forAll(
            row("//;\n1;2,3:4", 10),
            row("//?\n1?2?3?4", 10),
            row("//;\n1;2;3;4", 10),
            row("1,2,3:4", 10),
            row("1", 1),
        ) { input, expect ->

            val result = StringAddCalculator.add(input)

            result shouldBe expect
        }
    }
})
