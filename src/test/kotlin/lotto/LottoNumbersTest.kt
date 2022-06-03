package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {

    @Test
    fun `로또 번호가 중복된 경우 IllegalArgumentException 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(1, 2, 2, 2, 1, 1)
        }
    }

    @Test
    fun `로또 번호가 6개가 아닌 경우 IllegalArgumentException 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(1, 2, 3, 4)
        }
    }

    @Test
    fun `공통으로 포함된 번호의 수를 리턴한다`() {
        val lotto = LottoNumbers(1, 2, 3, 4, 5, 6)
        Assertions.assertThat(lotto.matchCount(LottoNumbers(1, 2, 3, 10, 11, 12))).isEqualTo(3)
    }

    private fun LottoNumbers(vararg numbers: Int) = LottoNumbers(numbers.map(::LottoNumber))
}
