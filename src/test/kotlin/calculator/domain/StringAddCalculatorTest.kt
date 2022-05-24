package calculator.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class StringAddCalculatorTest : FreeSpec({

    "문자열로 주어진 숫자의 합을 반환한다." - {
        val stringAddCalculator = StringAddCalculator()

        listOf(
            row("1:2:3", 6),
            row("1,2,5", 8),
            row("9,2:3", 14),
            row("5", 5)
        ).forEach { (text, result) ->
            "'$text'의 합은 '$result'다." {
                stringAddCalculator.add(text = text) shouldBe result
            }
        }
    }

    "빈 문자열이나 null이 주어질 경우 0을 반환한다." - {
        val stringAddCalculator = StringAddCalculator()

        listOf(
            null,
            "",
            " "
        ).forEach { text ->
            "'$text'이 주어지면 0을 반환한다." {
                stringAddCalculator.add(text = text) shouldBe 0
            }
        }
    }
})
