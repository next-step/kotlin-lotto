package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec

class LottoNumberTest : ExpectSpec({

    expect("로또 번호가 1보다 작으면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(0)
        }
    }

    expect("로또 번호가 45보다 크면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
})
