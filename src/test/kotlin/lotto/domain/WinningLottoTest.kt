package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @DisplayName(value = "당첨 등수를 반환할 수 있다.")
    @Test
    fun rank() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet(), LottoNumber(7))
        val lotto = Lotto(listOf(4, 5, 6, 7, 8, 9).map { LottoNumber(it) }.toSet())
        Assertions.assertThat(winningLotto.rankOfLotto(lotto)).isEqualTo(LottoRank.FIFTH)
    }

    @DisplayName(value = "보너스 번호 일치 여부에 따라 2등과 3등을 가를 수 있다.")
    @Test
    fun bonusRank() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet(), LottoNumber(7))
        val lottoSecond = Lotto(listOf(2, 3, 4, 5, 6, 7).map { LottoNumber(it) }.toSet())
        val lottoThird = Lotto(listOf(2, 3, 4, 5, 6, 8).map { LottoNumber(it) }.toSet())
        Assertions.assertThat(winningLotto.rankOfLotto(lottoSecond)).isEqualTo(LottoRank.SECOND)
        Assertions.assertThat(winningLotto.rankOfLotto(lottoThird)).isEqualTo(LottoRank.THIRD)
    }
}
