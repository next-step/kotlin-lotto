package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row

class LottoNumberTest : StringSpec({

    "로또 숫자가 1~45 사이가 아닐 경우 예외가 발생한다." {
        forAll(
            row(0),
            row(50)
        ) { number ->
            shouldThrow<IllegalArgumentException> {
                LottoNumber(number)
            }
        }
    }
})
