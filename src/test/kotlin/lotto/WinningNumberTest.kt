package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

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

    "로또 번호 매칭 결과를 반환한다" {
        val winningNumber = WinningNumber(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        forAll(
            row(createLotto(1, 2, 3, 7, 8, 9), LottoMatch.THREE),
            row(createLotto(1, 2, 3, 4, 7, 8), LottoMatch.FOUR),
            row(createLotto(1, 2, 3, 4, 5, 7), LottoMatch.FIVE),
            row(createLotto(1, 2, 3, 4, 5, 6), LottoMatch.SIX)
        ) { lotto, expected ->
            winningNumber.match(lotto) shouldBe expected
        }
    }
})
