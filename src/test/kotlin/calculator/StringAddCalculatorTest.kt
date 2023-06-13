package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({
    val stringAddCalculator = StringAddCalculator

    "기본 케이스 계산" {
        mapOf(
            "1,2" to 3,
            "1,2:3" to 6,
        ).forEach { (input, answer) ->
            stringAddCalculator.calculate(input) shouldBe answer
        }
    }

    "null 이거나 숫자가 하나인 경우 계산" {
        mapOf(
            null to 0,
            "" to 0,
            "1" to 1,
        ).forEach { (input, answer) ->
            stringAddCalculator.calculate(input) shouldBe answer
        }
    }

    "커스텀 구분자 계산" {
        mapOf(
            "//?\n1?2?3" to 6,
            "//;\n1;2;3" to 6
        ).forEach { (input, answer) ->
            stringAddCalculator.calculate(input) shouldBe answer
        }
    }

    "양수가 아니면 에러" {
        listOf(
            "-1,2,3",
            "a,b",
            "1,2,-3"
        ).forEach {
            shouldThrow<RuntimeException> {
                stringAddCalculator.calculate(it)
            }
        }
    }
})

