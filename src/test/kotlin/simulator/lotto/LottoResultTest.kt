package simulator.lotto


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoResultTest {
    @Test
    fun `로또 리스트로 부터 결과를 가져올 수 있다`() {
        val lottos = listOf(
            Lotto(setOf(1, 2, 3, 7, 8, 9)),
            Lotto(setOf(1, 2, 3, 4, 8, 9)),
            Lotto(setOf(1, 2, 3, 4, 5, 9)),
            Lotto(setOf(1, 2, 3, 4, 5, 6)),
        )

        val winningLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val result = LottoResult.aggregate(lottos, winningLotto)
        val totalPrize = Rank.FIRST.prize() + Rank.SECOND.prize() + Rank.THIRD.prize() + Rank.FOURTH.prize()

        assertThat(result.rankCount(Rank.FIRST)).isEqualTo(1)
        assertThat(result.rankCount(Rank.SECOND)).isEqualTo(1)
        assertThat(result.rankCount(Rank.THIRD)).isEqualTo(1)
        assertThat(result.rankCount(Rank.FOURTH)).isEqualTo(1)
        assertThat(result.totalMoney()).isEqualTo(totalPrize)
    }
}
