package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions.assertSoftly

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

    "로또 번호가 같은지 체크한다" {
        assertSoftly {
            assertThat(LottoNumber(5) == LottoNumber(5)).isTrue()
            assertThat(LottoNumber(5) == LottoNumber(4)).isFalse()
        }
    }
})
