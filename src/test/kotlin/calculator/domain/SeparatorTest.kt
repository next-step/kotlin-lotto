package calculator.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class SeparatorTest : FreeSpec({

    "주어진 문자열이 커스텀 구분자를 포함했는지 아닌지를 판별한다." - {
        listOf(
            row("//;\n", true),
            row("//A\n", true),
            row("|", false),
            row(";", false),
            row(",", false),
            row("1", false),
        ).forEach { (text, result) ->
            "'$text'가 커스텀 구분자인지 결과는 '$result'다." {
                Separator.matchByCustomSeparator(text) shouldBe result
            }
        }
    }
})
