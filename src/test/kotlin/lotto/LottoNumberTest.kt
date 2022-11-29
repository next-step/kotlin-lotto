package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.inspectors.forAll

class LottoNumberTest : StringSpec({
    "로또 번호는 1~45 범위를 가진다" {
        (1..45).toList()
            .forAll {
                shouldNotThrowAny { LottoNumber(it) }
            }
    }

    "범위를 벗어난 로또 번호를 생성할 시 예외를 던진다" {
        forAll(
            row(0),
            row(46)
        ) {
            shouldThrowAny { LottoNumber(it) }
        }
    }
})
