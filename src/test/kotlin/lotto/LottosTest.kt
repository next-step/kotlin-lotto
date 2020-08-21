package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {
    private val lotto1 = Lotto(listOf(1, 2, 3, 15, 16, 17))
    private val lotto2 = Lotto(listOf(35, 20, 1, 6, 7, 45))

    @DisplayName("로또 당첨 결과에 맞는 Rank 목록을 반환한다.")
    @Test
    fun matchLottos() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lottos = Lottos(listOf(lotto1, lotto2))
        val ranks = listOf(Rank.FIFTH, Rank.NONE)

        assertThat(lottos.matchLottos(winningNumbers, 17))
            .isEqualTo(ranks)
    }

    @DisplayName("Lottos 객체를 반환한다.")
    @Test
    fun newInstance() {
        assertThat(Lottos.newInstance(2, listOf(lotto1, lotto2)))
            .isInstanceOf(Lottos::class.java)
    }
}
