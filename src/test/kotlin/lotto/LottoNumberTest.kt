package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.assertj.core.api.SoftAssertions.assertSoftly

class LottoNumberTest : StringSpec({
    "로또 번호는 1 ~ 45 사이의 숫자다." {
        LottoNumber.of(1)
        LottoNumber.of(45)
    }

    "로또 번호는 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.of(0)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumber.of(46)
        }
    }

    "로또 번호가 같은지 체크한다" {
        assertSoftly {
            LottoNumber.of(5) shouldBe LottoNumber.of(5)
            LottoNumber.of(5) shouldNotBe LottoNumber.of(4)
        }
    }
})
