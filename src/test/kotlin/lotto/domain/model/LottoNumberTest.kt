package lotto.domain.model

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({
    "로또 숫자 범위 내의 값을 전달하는 경우 숫자로 변환할 수 있다." {
        forAll(
            row(1),
            row(20),
            row(45),
        ) { number ->
            LottoNumber.valueOf(number).value shouldBe number
        }
    }

    "로또 숫자의 범위를 벗어난 경우 IllegalArgumentException 예외를 던진다." {
        forAll(
            row(0),
            row(46),
            row(200),
        ) { number ->
            shouldThrowWithMessage<IllegalArgumentException>("로또 숫자의 범위는 1~45 입니다.") {
                LottoNumber.valueOf(number)
            }
        }
    }

    "문자열로 숫자 이외의 값을 전달하는 경우 IllegalArgumentException 예외를 던진다." {
        forAll(
            row("a"),
            row("i"),
            row(";"),
        ) { text ->
            shouldThrowWithMessage<IllegalArgumentException>("숫자 이외의 값일 수 없습니다.") {
                LottoNumber.valueOf(text)
            }
        }
    }

    "문자열로 음수를 전달하는 경우 IllegalArgumentException 예외를 던진다." {
        forAll(
            row("-1"),
            row("-45"),
        ) { text ->
            shouldThrowWithMessage<IllegalArgumentException>("숫자는 음수일 수 없습니다.") {
                LottoNumber.valueOf(text)
            }
        }
    }
})
