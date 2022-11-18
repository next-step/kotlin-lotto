package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoNumberTest : StringSpec() {
    init {
        "로또 넘버는 1~45만 가질 수 있다" {
            shouldNotThrowAny {
                for (i in 1..45) {
                    LottoNumber.from(i)
                }
            }
        }

        "그 외의 숫자에 대해서 예외가 발생한다" {
            shouldThrow<IllegalArgumentException> {
                LottoNumber.from(0)
            }
        }
    }
}
