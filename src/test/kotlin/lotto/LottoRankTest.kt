package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoRank
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoRankTest {
    private val bonusNumber = LottoNumber(45)

    @Test
    fun `로또는 당첨 번호랑 3개 일치하면 5등이다`() {
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 14, 15, 16), bonusNumber)
        Assertions.assertThat(LottoRank.of(winningNumbers, lottoNumbers)).isEqualTo(LottoRank.FIFTH)
    }

    @Test
    fun `로또는 당첨 번호랑 4개 일치하면 4등이다`() {
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 15, 16), bonusNumber)
        Assertions.assertThat(LottoRank.of(winningNumbers, lottoNumbers)).isEqualTo(LottoRank.FOURTH)
    }

    @Test
    fun `로또는 당첨 번호랑 5개 일치하고 보너스 볼과 일치하지 않으면 3등이다`() {
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 16), bonusNumber)
        Assertions.assertThat(LottoRank.of(winningNumbers, lottoNumbers)).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `로또는 당첨 번호랑 5개 일치하고 보너스 볼과 일치하면 2등이다`() {
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 45)
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber)
        Assertions.assertThat(LottoRank.of(winningNumbers, lottoNumbers)).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `로또는 당첨 번호랑 6개 일치하면 1등이다`() {
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber)
        Assertions.assertThat(LottoRank.of(winningNumbers, lottoNumbers)).isEqualTo(LottoRank.FIRST)
    }
}
