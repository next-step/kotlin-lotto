package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    fun `상금 리스트를 반환합니다`() {
        val lottos = Lottos(
            listOf(
                Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.of(listOf(1, 2, 3, 4, 5, 49))
            )
        )
        val winnigLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 49))

        assertThat(lottos.matchNumbers(winnigLotto, LottoBall(28)).reward)
            .containsExactlyInAnyOrder(Reward.FIRST_RANK, Reward.THIRD_RANK)
        assertThat(lottos.matchNumbers(winnigLotto, LottoBall(6)).reward)
            .containsExactlyInAnyOrder(Reward.FIRST_RANK, Reward.SECOND_RANK)
    }

    @Test
    fun `로또 리스트들을 합친 로또 리스트를 반환합니다`() {
        val lottosA = Lottos(
            listOf(
                Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.of(listOf(1, 2, 3, 4, 5, 49))
            )
        )
        val lottosB = Lottos(
            listOf(
                Lotto.of(listOf(1, 2, 3, 6, 5, 49))
            )
        )

        val result = lottosA.combine(lottosB)

        assertThat(result.lottos).containsExactlyInAnyOrder(
            Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
            Lotto.of(listOf(1, 2, 3, 4, 5, 49)),
            Lotto.of(listOf(1, 2, 3, 6, 5, 49))
        )
    }
}
