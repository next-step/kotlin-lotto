package calculator.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly

internal class SeparatorsTest : FreeSpec({

    "문자열과 패턴이 일치하는 구분자를 사용해서 문자열을 나눈 결과를 반환한다." - {
        listOf(
            row("3:5:2", listOf("3", "5", "2")),
            row("1,1,1", listOf("1", "1", "1")),
            row("3:2", listOf("3", "2")),
            row("5", listOf("5")),
            row("//;\n3;5;2", listOf("3", "5", "2")),
            row("//a\n1a1a1", listOf("1", "1", "1")),
            row("//!\n3!5!2", listOf("3", "5", "2")),
            row("// \n3 5 2", listOf("3", "5", "2")),
        ).forEach { (text, result) ->
            "'$text'를 나눈 결과는 '$result' 다." {
                Separators().splitText(text = text).shouldContainExactly(result)
            }
        }
    }
})
