package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @DisplayName(value = "당첨 등수를 반환할 수 있다.")
    @Test
    fun winningCount() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
        val lotto = Lotto(listOf(4, 5, 6, 7, 8, 9).map { LottoNumber(it) }.toSet())
        Assertions.assertThat(winningLotto.rankOfLotto(lotto)).isEqualTo(LottoRank.FOURTH)
    }
}
