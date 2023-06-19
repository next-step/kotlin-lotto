package lotto.vo

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row

class LottoNumberTest : FreeSpec({

    "로또 번호는 1~45 사이의 숫자로만 생성 가능하다." - {
        "성공" {
            forAll(
                row(1),
                row(45)
            ) { number ->
                shouldNotThrowAny { LottoNumber(number) }
            }
        }

        "실패" {
            forAll(
                row(0),
                row(46)
            ) { number ->
                shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 1~45 사이의 숫자여야 합니다.") { LottoNumber(number) }
            }
        }
    }
})
