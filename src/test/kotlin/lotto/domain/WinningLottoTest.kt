package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @DisplayName("로또번호를 3개 맞추면 THREE 를 반환한다.")
    @Test
    fun threeMatch() {
        val lotto = Lotto.from(listOf(1, 2, 3, 9, 8, 7))
        assertThat(Fixture.winningLotto.checkMatch(lotto))
            .isEqualTo(Match.THREE)
    }

    @DisplayName("로또번호를 4개 맞추면 FOUR 를 반환한다.")
    @Test
    fun fourMatch() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 8, 7))
        assertThat(Fixture.winningLotto.checkMatch(lotto))
            .isEqualTo(Match.FOUR)
    }

    @DisplayName("로또번호를 5개 맞추면 FIVE 를 반환한다.")
    @Test
    fun fiveMatch() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 8))
        assertThat(Fixture.winningLotto.checkMatch(lotto))
            .isEqualTo(Match.FIVE)
    }

    @DisplayName("로또번호를 5개와 보너스볼을 맞추면 BONUS 를 반환한다.")
    @Test
    fun bonusMatch() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 7))
        assertThat(Fixture.winningLotto.checkMatch(lotto))
            .isEqualTo(Match.BONUS)
    }

    @DisplayName("로또번호를 6개 맞추면 SIX 를 반환한다.")
    @Test
    fun sixMatch() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        assertThat(Fixture.winningLotto.checkMatch(lotto))
            .isEqualTo(Match.SIX)
    }
}
