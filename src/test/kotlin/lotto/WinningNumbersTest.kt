package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    fun `당첨 번호를 입력받는다`() {
        val winningNumbers = WinningNumbers(LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))
        assertThat(winningNumbers.winningNumbers.lottoNumbers.map { it.number })
            .containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `보너스 번호는 당첨번호와 겹치지 않는다`() {
        assertThatThrownBy { WinningNumbers(LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(6)) }
            .isInstanceOf(IllegalArgumentException::class.java).hasMessage("Bonus must not in winningNumbers")
    }

    @Test
    fun matchNumbersTest() {
        val winningNumbers = WinningNumbers(LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))
        val lotto = Lotto { LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6)) }
        assertThat(winningNumbers.matchNumbers(lotto)).isEqualTo(6)
    }
}
