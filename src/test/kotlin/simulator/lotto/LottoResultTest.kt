package simulator.lotto


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoResultTest {
    @Test
    fun `로또리스트로 부터 1등, 2등, 3등, 4등을 나타낼 수 있다`() {
        val lottos = listOf(
            Lotto(setOf(1, 2, 3, 7, 8, 9)),
            Lotto(setOf(1, 2, 3, 4, 8, 9)),
            Lotto(setOf(1, 2, 3, 4, 5, 9)),
            Lotto(setOf(1, 2, 3, 4, 5, 6)),
        )

        val winLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val result = LottoResult(lottos, winLotto)

        assertThat(result.first).isEqualTo(1)
        assertThat(result.second).isEqualTo(1)
        assertThat(result.third).isEqualTo(1)
        assertThat(result.fourth).isEqualTo(1)
    }

    @Test
    fun `로또리스트로 총 당첨금을 알아낼 수 있다`() {
        val lottos = listOf(
            Lotto(setOf(1, 2, 3, 7, 8, 9)),
            Lotto(setOf(1, 2, 3, 4, 8, 9)),
            Lotto(setOf(1, 2, 3, 4, 5, 9)),
            Lotto(setOf(1, 2, 3, 4, 5, 6)),
        )

        val winLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val result = LottoResult(lottos, winLotto)

        assertThat(result.money()).isEqualTo(LottoResult.FIRST_PRIZE + LottoResult.SECOND_PRIZE + LottoResult.THIRD_PRIZE + LottoResult.FOURTH_PRIZE)
    }
}
