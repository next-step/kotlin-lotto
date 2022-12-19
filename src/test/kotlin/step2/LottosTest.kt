package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import step2.domain.Lotto
import step2.domain.Lottos

class LottosTest {

    @DisplayName("정답이 3개인 로또")
    @Test
    fun answerCountTest() {
        val answer = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 10, 11, 12))
        val lotto3 = Lotto(listOf(1, 2, 30, 40, 42, 45))

        val lottos = Lottos(listOf(lotto1, lotto2, lotto3))
        val winCounts = lottos.getAnswerCountList(answer)

        assertThat(winCounts).isEqualTo(listOf(6, 3, 2))
    }
}
