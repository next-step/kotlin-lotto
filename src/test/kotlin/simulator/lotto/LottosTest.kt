package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {
    @Test
    fun `로또 숫자를 받아서 결과 리스트를 반환할 수 있다`() {
        val numbers = listOf(
            setOf(1, 2, 3, 4, 5, 6),
            setOf(1, 2, 3, 4, 5, 7),
            setOf(1, 2, 3, 4, 7, 8)
        )
        val winningLotto = Lotto(setOf(1, 2, 3, 4, 5, 7))
        val bonusNumber = 6
        val lottos = Lottos(numbers.map { Lotto(it) })
        val ranks = lottos.ranks(winningLotto, bonusNumber)

        assertThat(ranks.values).isEqualTo(listOf(Rank.SECOND, Rank.FIRST, Rank.THIRD))
    }
}