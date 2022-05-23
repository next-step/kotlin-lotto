package calculator.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

internal class SeparatorTest : FreeSpec({

    "문자열에 해당하는 구분자를 찾을 수 있다." - {
        listOf(
            ",",
            ":",
        ).forEach { text ->
            "'$text' 구분자를 찾을 수 있다." {
                Separator.values().shouldContain(Separator.findByText(text = text))
            }
        }
    }

    "문자열에 해당하는 구분자를 찾지 못할 경우 예외가 발생한다." - {
        listOf(
            "",
            " ",
            ",,",
            "##",
            "123"
        ).forEach { text ->
            "구분자가 아닌 '$text'를 입력할 경우 예외가 발생한다." {
                val exception = shouldThrowExactly<RuntimeException> { Separator.findByText(text = text) }
                exception.message shouldBe "'$text'는 문자열 덧셈 계산기 구분자가 아닙니다."
            }
        }
    }
})
