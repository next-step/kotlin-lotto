package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoCashTest : StringSpec({
    "로또 구입 금액을 전달하는 경우 숫자로 변환할 수 있다." {
        forAll(
            row("1000"),
            row("14000"),
        ) { number ->
            LottoCash.valueOf(number).value shouldBe number.toInt()
        }
    }

    "문자열로 숫자 이외의 값을 전달하는 경우 IllegalArgumentException 예외를 던진다." {
        forAll(
            row("a"),
            row("i"),
            row(";"),
        ) { text ->
            shouldThrowWithMessage<IllegalArgumentException>("숫자 이외의 값일 수 없습니다.") {
                LottoCash.valueOf(text)
            }
        }
    }

    "문자열로 음수를 전달하는 경우 IllegalArgumentException 예외를 던진다." {
        forAll(
            row("-1000"),
            row("-100000"),
        ) { text ->
            shouldThrowWithMessage<IllegalArgumentException>("숫자는 음수일 수 없습니다.") {
                LottoCash.valueOf(text)
            }
        }
    }
})
