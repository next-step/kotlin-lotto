package calculator.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

internal class SeparatorTest : FreeSpec({

    "주어진 문자열이 커스텀 구분자 정규식 패턴과 일치하는지를 포함했는지 아닌지를 판별한다." - {
        listOf(
            row("//;\n", true),
            row("//A\n", true),
            row("|", false),
            row(";", false),
            row(",", false),
            row("1", false),
        ).forAll { (text, result) ->
            "'$text'가 커스텀 구분자인지 결과는 '$result'다." {
                Custom.isMatchWithText(text = text) shouldBe result
            }
        }
    }

    "커스텀 구분자를 통해 문자열을 나눌 수 있다." - {
        listOf(
            row("//;\n3;5;2", listOf("3", "5", "2")),
            row("//a\n1a1a1", listOf("1", "1", "1")),
            row("//!\n3!5!2", listOf("3", "5", "2")),
            row("// \n3 5 2", listOf("3", "5", "2")),
        ).forAll { (text, result) ->
            "'$text'를 커스텀 구분자로 나눈 결과는 '$result'다." {
                Custom.split(text = text).shouldContainExactly(result)
            }
        }
    }

    "기본 구분자를 통해 문자열을 나눌 수 있다." - {
        listOf(
            row("3:5:2", listOf("3", "5", "2")),
            row("1,1,1", listOf("1", "1", "1")),
            row("3:2", listOf("3", "2")),
            row("5", listOf("5")),
        ).forAll { (text, result) ->
            "'$text'를 기본 구분자로 나눈 결과는 '$result'다." {
                Default.split(text = text).shouldContainExactly(result)
            }
        }
    }
})
