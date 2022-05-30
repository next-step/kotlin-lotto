package lotto

import lotto.domain.LottoNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {

    @Test
    fun `로또 중복되지 않는 6개의 번호를 가진다`() {
        val lottoNumbers = LottoNumbers.random()
        Assertions.assertThat(lottoNumbers.numbers.size).isEqualTo(6)
        Assertions.assertThat(lottoNumbers.numbers.toSet().size).isEqualTo(6)
    }

    @Test
    fun `로또 번호가 중복된 경우 IllegalArgumentException 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(listOf(1, 2, 2, 2, 1, 1))
        }
    }

    @Test
    fun `로또 번호가 6개가 아닌 경우 IllegalArgumentException 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(listOf(1, 2, 3, 4))
        }
    }
}
