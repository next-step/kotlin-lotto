package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.domain.LottoNumber

class LottoNumberTest : StringSpec({
    "로또 반허 생성시 1 ~ 45를 벗어난 숫자가 전달될 경우 예외를 반환한다." {
        assertSoftly {
            shouldThrow<IllegalArgumentException> { LottoNumber(0) }
            shouldThrow<IllegalArgumentException> { LottoNumber(46) }
        }
    }
})
