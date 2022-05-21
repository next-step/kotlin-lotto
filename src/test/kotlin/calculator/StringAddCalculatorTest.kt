package calculator

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class StringAddCalculatorTest : FreeSpec({
    val calculator = StringAddCalculator()

    "결과값이 0이되는 경우" - {
        listOf(
            "빈 문자열" to "  ",
            "null" to null,
        ).forEach { (name, input) ->
            name {
                calculator.add(input) shouldBe 0
            }
        }
    }
})
