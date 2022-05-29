package _string_add_calculator

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class StringAddCalculatorTest : ExpectSpec({
    context("add") {
        val calculator = StringAddCalculator()

        expect("빈 문자열 또는 null을 입력할 경우 0을 반환한다.") {
            forAll(
                row(""),
                row(null)
            ) { text ->
                val result = calculator.add(text)

                result shouldBe 0
            }
        }
    }
})
