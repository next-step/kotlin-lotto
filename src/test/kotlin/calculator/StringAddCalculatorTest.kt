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

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다" - {
        listOf("1", "5", "9").forEach { input ->
            "$input 을 입력한 경우" {
                calculator.add(input) shouldBe input.toInt()
            }
        }
    }
})
