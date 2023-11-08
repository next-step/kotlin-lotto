package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoRank
import lotto.domain.ManualLotto
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또는 6개의 숫자로 이뤄져 있다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 6, 7)) }
    }

    @Test
    fun `로또는 1~49 사이의 숫자들이다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { ManualLotto(LottoNumbers(0, 1, 2, 3, 4, 5)) }
    }

    @Test
    fun `로또는 숫자들이 겹치면 안된다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { ManualLotto(LottoNumbers(1, 1, 2, 3, 4, 5)) }
    }

    private val bonusNumber = LottoNumber(49)
    @Test
    fun `로또는 당첨 번호랑 3개 일치하면 5등이다`() {
        val lotto = ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 14, 15, 16), bonusNumber)
        Assertions.assertThat(lotto.getLottoResult(winningNumbers)).isEqualTo(LottoRank.FIFTH)
    }

    @Test
    fun `로또는 당첨 번호랑 4개 일치하면 4등이다`() {
        val lotto = ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 15, 16), bonusNumber)
        Assertions.assertThat(lotto.getLottoResult(winningNumbers)).isEqualTo(LottoRank.FOURTH)
    }

    @Test
    fun `로또는 당첨 번호랑 5개 일치하고 보너스 볼과 일치하지 않으면 3등이다`() {
        val lotto = ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 16), bonusNumber)
        Assertions.assertThat(lotto.getLottoResult(winningNumbers)).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `로또는 당첨 번호랑 5개 일치하고 보너스 볼과 일치하면 2등이다`() {
        val lotto = ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 49))
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber)
        Assertions.assertThat(lotto.getLottoResult(winningNumbers)).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `로또는 당첨 번호랑 6개 일치하면 1등이다`() {
        val lotto = ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber)
        Assertions.assertThat(lotto.getLottoResult(winningNumbers)).isEqualTo(LottoRank.FIRST)
    }
}
