package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LottosTest {

    @Test
    fun `구매한 로또번호의 랭킹을 확인한다`() {
        // given
        val lottos = Lottos(
            listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        )
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val actual = lottos.matchWinningNumbers(winningLotto)

        // then
        val expected = mapOf(Ranking.FIRST to 1)
        assertThat(actual).isEqualTo(expected)
    }
}