package lotto

import lotto.domain.LottoNumbers
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    @Test
    fun `getContainCount가 잘 작동한다`() {
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)

        val winningNumbers1 = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6))
        assertThat(lottoNumbers.getContainCount(winningNumbers1)).isEqualTo(6)
        val winningNumbers2 = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 16))
        assertThat(lottoNumbers.getContainCount(winningNumbers2)).isEqualTo(5)
        val winningNumbers3 = WinningNumbers(LottoNumbers(1, 2, 3, 4, 15, 16))
        assertThat(lottoNumbers.getContainCount(winningNumbers3)).isEqualTo(4)
        val winningNumbers4 = WinningNumbers(LottoNumbers(11, 12, 13, 14, 15, 16))
        assertThat(lottoNumbers.getContainCount(winningNumbers4)).isEqualTo(0)
    }
}
