package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row

class LottoNumberTest : StringSpec({
    "로또 번호는 1 미만 45 초과인 경우 IllegalArgumentException이 발생한다" {
        forAll(
            row(0),
            row(46),
        ) {
            shouldThrow<IllegalArgumentException> {
                LottoNumber(it)
            }
        }
    }
})
