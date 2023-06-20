package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({
    "로또 숫자는 1이사 45이하 이어야 한다" {

        LottoNumber(1).number shouldBe 1
        LottoNumber(45).number shouldBe 45

        shouldThrow<IllegalArgumentException> {
            LottoNumber(0)
        }

        shouldThrow<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
})
