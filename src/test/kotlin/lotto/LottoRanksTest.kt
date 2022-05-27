package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoRanksTest {

    @Test
    fun `LottoRanks 객체 생성`() {
        val lottoRanks = LottoRanks()
        lottoRanks.add(LottoRank.LOSE)
        lottoRanks.add(LottoRank.LOSE)
        lottoRanks.add(LottoRank.THREE_MATCH)
        lottoRanks.add(LottoRank.FOUR_MATCH)
        lottoRanks.add(LottoRank.FOUR_MATCH)

        val rankCount = lottoRanks.getRankCount(LottoRank.FOUR_MATCH)

        assertThat(rankCount).isEqualTo(2)
    }
}
