package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    @Test
    fun `로또 번호와 당첨 번호와 비교해서 알맞는 일치 개수를 반환한다`() {
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber(7)

        val winningNumbers1 = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber)
        assertThat(lottoNumbers.getContainCount(winningNumbers1)).isEqualTo(6)
        val winningNumbers2 = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 16), bonusNumber)
        assertThat(lottoNumbers.getContainCount(winningNumbers2)).isEqualTo(5)
        val winningNumbers3 = WinningNumbers(LottoNumbers(1, 2, 3, 4, 15, 16), bonusNumber)
        assertThat(lottoNumbers.getContainCount(winningNumbers3)).isEqualTo(4)
        val winningNumbers4 = WinningNumbers(LottoNumbers(11, 12, 13, 14, 15, 16), bonusNumber)
        assertThat(lottoNumbers.getContainCount(winningNumbers4)).isEqualTo(0)
    }

    @Test
    fun `보너스 번호가 로또 번호 안에 있다면 true를 반환한다`() {
        val bonusNumber = LottoNumber(7)
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber)
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 7)
        assertThat(lottoNumbers.isMatchBonus(winningNumbers)).isEqualTo(true)
    }

    @Test
    fun `보너스 번호가 lottoNumbers에 없다면 false 반환한다`() {
        val bonusNumber = LottoNumber(7)

        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber)
        assertThat(lottoNumbers.isMatchBonus(winningNumbers)).isEqualTo(false)
    }
}
