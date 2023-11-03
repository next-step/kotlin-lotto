package lotto.dto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    @Test
    fun `로또 번호 생성`() {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        assert(lottoNumbers.numbers.size == 6)
    }

    @Test
    fun `로또 번호 숫자가 6개가 아닌 경우 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 숫자 범위가 넘어가면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 숫자가 중복되면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumbers(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 숫자 비교`() {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumbers2 = LottoNumbers(listOf(1, 2, 3, 4, 5, 9))
        assertThat(lottoNumbers.compareLottoNumbers(lottoNumbers2)).isEqualTo(5)
    }
}
