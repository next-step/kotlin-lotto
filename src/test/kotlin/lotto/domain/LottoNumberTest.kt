package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

internal class LottoNumberTest : StringSpec({
    "로또 번호는 1~45 사이의 숫자만 가능하다." {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
})
