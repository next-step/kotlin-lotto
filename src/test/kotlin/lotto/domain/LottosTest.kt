package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {

    @Test
    fun `구매한 로또번호의 랭킹을 확인한다`() {
        // given
        val lottos = Lottos(
            listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        )
        val bonusNumber = 7
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), bonusNumber)

        // when
        val actual = lottos.matchWinningNumbers(winningLotto, bonusNumber)

        // then
        val expected = mapOf(Ranking.FIRST to 1)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `구매한 로또번호가 5개 맞고 보너스번호가 맞을 경우 2등이 된다`() {
        // given
        val lottos = Lottos(
            listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        )
        val bonusNumber = 7
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), bonusNumber)

        // when
        val actual = lottos.matchWinningNumbers(winningLotto, bonusNumber)

        // then
        val expected = mapOf(Ranking.SECOND to 1)
        assertThat(actual).isEqualTo(expected)
    }
}
