package lotto.dto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `로또 번호 생성`() {
        val lottoNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6))
        assert(lottoNumber.numbers.size == 6)
    }

    @Test
    fun `로또 번호 숫자가 6개가 아닌 경우 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumber(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 숫자 범위가 넘어가면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumber(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 숫자 비교`() {
        val lottoNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumber2 = LottoNumber(listOf(1, 2, 3, 4, 5, 9))
        assertThat(lottoNumber.compare(lottoNumber2)).isEqualTo(5)
    }
}
