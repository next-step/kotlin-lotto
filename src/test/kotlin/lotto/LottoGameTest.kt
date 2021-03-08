package lotto

import lotto.LottoDrawMachineTest.LottoNumber
import lotto.RankingTest.Ranking.Rank.FIRST
import lotto.RankingTest.Ranking.Rank.MISS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `구매 수량만큼 비교한다`() {
        val pickLottoNumbers: List<LottoNumber> = listOf(
            LottoNumber(1, 2, 3, 4, 5, 6),
            LottoNumber(1, 2, 3, 4, 5, 6),
            LottoNumber(11, 12, 13, 14, 15, 16)
        )

        val winningNumber: LottoNumber = LottoNumber(1, 2, 3, 4, 5, 6)

        val rank = pickLottoNumbers.map { RankingTest.Ranking(it, winningNumber).rank }

        assertThat(rank).containsExactlyInAnyOrder(FIRST, FIRST, MISS)
    }
}
