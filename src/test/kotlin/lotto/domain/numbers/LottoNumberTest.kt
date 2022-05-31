package lotto.domain.numbers

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `로또 번호는 1과 45 사이의 번호로 이루어져 있다`() {
        val lottoNumbers = (1..45).map { it }

        Assertions.assertThatNoException().isThrownBy { lottoNumbers.map { LottoNumber(it) } }
    }

    @Test
    fun `1 과 45 사이의 숫자가 아닐 경우 IllegalArgumentException 을 반환한다`() {
        val lessThanOneLottoNumber = 0
        val greaterThanFortyFiveLottoNumber = 46

        Assertions.assertThatIllegalArgumentException().isThrownBy { LottoNumber(lessThanOneLottoNumber) }
        Assertions.assertThatIllegalArgumentException().isThrownBy { LottoNumber(greaterThanFortyFiveLottoNumber) }
    }
}
