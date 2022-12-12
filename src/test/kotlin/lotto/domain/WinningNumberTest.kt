package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row

class WinningNumberTest : StringSpec({
    "당첨 번호는 중복 없이 6개의 로또 번호를 가진다" {
        shouldNotThrowAny {
            WinningNumber(1, 2, 3, 4, 5, 6)
        }
    }

    "범위를 벗어난 당첨 번호를 생성할 시 예외를 던진다" {
        forAll(
            row(intArrayOf(1, 2, 3, 4, 5)),
            row(intArrayOf(1, 2, 3, 4, 5, 6, 7))
        ) {
            shouldThrowAny {
                WinningNumber(*it)
            }
        }
    }

    "로또 번호 매칭 결과를 반환한다" {
        val winningNumber = WinningNumber(1, 2, 3, 4, 5, 6)

        shouldNotThrowAny {
            winningNumber.match(listOf(Lotto(1, 2, 3, 4, 5, 6)))
        }
    }
})
