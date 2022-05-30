package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class LottoRanksTest {

    private val lottoRanks = LottoRanks()

    @Test
    fun `match 카운터의 값에 따른 LottoRanks 의 LottoRank Count 값 확인`() {
        lottoRanks.add(LottoRank.LOSE)
        val rankCount = lottoRanks.getRankCount(LottoRank.LOSE)

        assertThat(rankCount).isEqualTo(1)
    }

    @Test
    fun `당첨에 대한 랭크가 존재하는지 확인`() {
        assertThat(lottoRanks.getRanks().keys).containsAll(
            listOf(
                LottoRank.LOSE,
                LottoRank.THREE_MATCH,
                LottoRank.FOUR_MATCH,
                LottoRank.FIVE_MATCH,
                LottoRank.SIX_MATCH
            )
        )
    }

    @Test
    fun `현재 당첨금 확인`() {
        lottoRanks.add(LottoRank.THREE_MATCH)

        assertThat(lottoRanks.getWinPrice()).isEqualTo(BigDecimal(5_000))
    }
}
