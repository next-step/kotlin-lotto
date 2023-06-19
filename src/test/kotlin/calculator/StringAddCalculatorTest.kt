package calculator

import calculator.domain.StringAddCalculator
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class StringAddCalculatorTest : ExpectSpec({
    val calculator = StringAddCalculator()

    context("빈 문자열 또는 null을 입력할 경우") {
        val operations = listOf(
            "",
            null
        )
        expect("0을 반환한다.") {
            operations.forAll { operation ->
                val actual = calculator.execute(operation)
                actual shouldBe 0
            }
        }
    }

    context("숫자 한개만 전달된 경우") {
        val operations = listOf(
            "1",
            "23",
            "456"
        )
        expect("해당 값을 반환한다.") {
            operations.forAll { operation ->
                val actual = calculator.execute(operation)
                actual shouldBe operation.toInt()
            }
        }
    }
})
