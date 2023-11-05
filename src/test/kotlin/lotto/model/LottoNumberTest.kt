package lotto.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoNumberTest : StringSpec({
    "1~46 사이의 수 이어야한다" {
        shouldNotThrow<IllegalArgumentException> {
            (1..46).forEach { LottoNumber(it) }
        }
    }

    "1~46 범위에 벗어나는 경우 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(-1)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumber(0)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumber(47)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumber(50)
        }
    }
})
