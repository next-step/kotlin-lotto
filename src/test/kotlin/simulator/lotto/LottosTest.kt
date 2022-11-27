package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {
    @Test
    fun `로또 숫자를 받아서 일치하는 갯수 리스트를 반환할 수 있다`() {
        val numbers = listOf(
            setOf(1, 2, 3, 4, 5, 6),
            setOf(1, 2, 3, 4, 5, 7),
            setOf(1, 2, 3, 4, 7, 8)
        )
        val winningLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val lottos = Lottos(numbers.map { Lotto(it) })

        assertThat(lottos.matches(winningLotto)).isEqualTo(listOf(6, 5, 4))
    }
}