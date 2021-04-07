package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankPaperTest {

    @Test
    fun `랭크 개수 확인`() {
        val lottoRankPaper = LottoRankPaper(listOf(LottoRank.FIRST))
        val rankCount = lottoRankPaper.getRankCount(LottoRank.FIRST)
        assertThat(rankCount).isEqualTo(1)
    }

    @Test
    fun `랭크 총 금액`() {
        val lottoRankPaper = LottoRankPaper(listOf(LottoRank.FIFTH))
        val prizeRate = lottoRankPaper.getPrizeRate()
        assertThat(prizeRate).isEqualTo(5.0)
    }
}
