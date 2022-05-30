package calculator.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class PositiveNumberTest : FreeSpec({

    "문자열로 숫자 이외의 값이 전달되면 예외가 발생한다." - {
        listOf(
            "",
            " ",
            "1*",
            "%$",
        ).forEach { text ->
            "'$text' 가 전달되면 예외가 발생한다." {
                val exception =
                    shouldThrowExactly<RuntimeException> { PositiveNumber.from(text = text) }
                exception.message shouldBe "'$text' 는 정수로 변환할 수 없는 문자열입니다."
            }
        }
    }

    "문자열로 음수가 전달되면 예외가 발생한다." - {
        listOf(
            "-1",
            "-10",
            "-100",
        ).forEach { text ->
            "'$text' 가 전달되면 예외가 발생한다." {
                val exception =
                    shouldThrowExactly<RuntimeException> { PositiveNumber.from(text = text) }
                exception.message shouldBe "덧셈 피연산자 값은 음수일 수 없습니다. ($text)"
            }
        }
    }

    "음수가 전달되면 예외가 발생한다." - {
        listOf(
            -1,
            -10,
            -100,
        ).forEach { negativeNumber ->
            "'$negativeNumber' 가 전달되면 예외가 발생한다." {
                val exception =
                    shouldThrowExactly<RuntimeException> { PositiveNumber(value = negativeNumber) }
                exception.message shouldBe "덧셈 피연산자 값은 음수일 수 없습니다. ($negativeNumber)"
            }
        }
    }
})
