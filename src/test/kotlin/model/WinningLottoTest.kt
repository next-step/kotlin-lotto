package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호를 입력 받는다")
    fun `inputBonusNumber`() {
        val winningLotto = WinningLotto(createLotto(1, 2, 3, 4, 5, 6), LottoNumber.from(7))
        assertThat(winningLotto.bonusNumber).isNotNull()
    }

    @Test
    @DisplayName("로또를 가지고 3 등을 알 수 있다")
    fun `getRankThird`() {
        val lottoNumber = createLotto(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(lottoNumber, 7)
        val lotto = createLotto(2, 3, 4, 5, 6, 8)
        assertThat(winningLotto.rank(lotto)).isEqualTo(Rank.THIRD)
    }

    @Test
    @DisplayName("보너스 번호를 입력 받을 수 있다")
    fun `inputBonusLottoNumber`() {
        val lottoNumber = createLotto(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(lottoNumber, 7)
        assertThat(winningLotto.bonusNumber.value).isEqualTo(7)
    }

    @Test
    @DisplayName("로또를 가지고  당첨 등수를 알 수 있다")
    fun `getRank`() {
        val lottoNumber = createLotto(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(lottoNumber, 7)
        val lotto = createLotto(4, 5, 6, 7, 8, 9)
        assertThat(winningLotto.rank(lotto)).isEqualTo(Rank.FIFTH)
    }

    @Test
    @DisplayName("로또를 가지고 2 등을 알 수 있다")
    fun `getRankSecond`() {
        val lottoNumber = createLotto(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(lottoNumber, 7)
        val lotto = createLotto(2, 3, 4, 5, 6, 7)
        assertThat(winningLotto.rank(lotto)).isEqualTo(Rank.SECOND)
    }

    @Test
    @DisplayName("로또 당첨 번호를 입력 받을 수 있다")
    fun `inputWinningLotto`() {
        val lottoNumber = createLotto(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(lottoNumber, 7)
        assertThat(winningLotto).isNotNull
    }

    @Test
    @DisplayName("로또와 당첨 번호 사이의 matchResult를 알 수 있다")
    fun `getMatchCount`() {
        val lottoNumber = createLotto(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(lottoNumber, 7)
        val lotto = createLotto(4, 5, 6, 7, 8, 9)
        assertThat(winningLotto.rank(lotto)).isNotNull()
    }

    private fun createLotto(vararg integers: Int): Lotto {
        return Lotto(integers.toSet().map { LottoNumber.from(it) }.toSet())
    }
}
