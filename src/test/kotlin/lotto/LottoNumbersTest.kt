package lotto

import lotto.domain.LottoNumber
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

    @Test
    fun `당첨번호가 주어질 때, 해당번호의 개수를 리턴한다`() {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)
        Assertions.assertThat(lottoNumbers.calculateWinningCount(winningNumbers.take(6))).isEqualTo(6)
        Assertions.assertThat(lottoNumbers.calculateWinningCount(winningNumbers.take(3))).isEqualTo(3)
        Assertions.assertThat(lottoNumbers.calculateWinningCount(winningNumbers.take(0))).isEqualTo(0)
    }
}
