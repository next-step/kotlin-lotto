package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({
    "로또 번호는 1 ~ 45 사이의 숫자다." {
        LottoNumber(1)
        LottoNumber(45)
    }

    "로또 번호는 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(0)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
})
