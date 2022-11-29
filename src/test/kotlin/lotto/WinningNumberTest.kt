package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row

class WinningNumberTest : StringSpec({
    "당첨 번호는 중복 없이 6개의 로또 번호를 가진다" {
        shouldNotThrowAny {
            WinningNumber(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        }
    }

    "범위를 벗어난 당첨 번호를 생성할 시 예외를 던진다" {
        forAll(
            row(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5)
                )
            ),
            row(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                    LottoNumber(7),
                )
            )
        ) {
            shouldThrowAny {
                WinningNumber(it)
            }
        }
    }
})
