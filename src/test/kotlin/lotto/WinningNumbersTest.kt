package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumbers
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    fun `당첨 번호를 입력받는다`() {
        val winningNumbers = WinningNumbers(LottoNumbers.of(listOf(1, 2, 3, 4, 5)))
        assertThat(winningNumbers.numbers.lottoNumbers[0].number).isEqualTo(1)
        assertThat(winningNumbers.numbers.lottoNumbers[1].number).isEqualTo(2)
        assertThat(winningNumbers.numbers.lottoNumbers[2].number).isEqualTo(3)
        assertThat(winningNumbers.numbers.lottoNumbers[3].number).isEqualTo(4)
        assertThat(winningNumbers.numbers.lottoNumbers[4].number).isEqualTo(5)
    }

    @Test
    fun matchNumbersTest() {
        val winningNumbers = WinningNumbers(LottoNumbers.of(listOf(1, 2, 3, 4, 5)))
        val lotto = Lotto { LottoNumbers.of(listOf(1, 2, 3, 4, 5)) }
        assertThat(winningNumbers.matchNumbers(lotto)).isEqualTo(5)
    }
}
