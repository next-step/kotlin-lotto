package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRanksTest {
    @Test
    fun `전체 당첨 금액 연산 테스트`() {
        // given
        val ranks = LottoRanks(
            listOf(
                LottoRank.FIRST,
                LottoRank.SECOND,
                LottoRank.THIRD
            )
        )

        // when
        val totalWinningMoney = ranks.getTotalWinningMoney()

        // then
        assertEquals(2_001_550_000, totalWinningMoney)
    }

    @Test
    fun `LottoRank별로 그룹화하여 카운트`() {
        // given
        val lottoRanks = LottoRanks(
            listOf(
                LottoRank.FIRST,
                LottoRank.SECOND,
                LottoRank.SECOND,
                LottoRank.THIRD,
                LottoRank.THIRD,
                LottoRank.THIRD,
                LottoRank.FOURTH,
                LottoRank.FOURTH,
                LottoRank.FOURTH,
                LottoRank.FOURTH
            )
        )

        // when
        val lottoRankCount = lottoRanks.groupByLottoRank()

        // then
        assertEquals(1, lottoRankCount[LottoRank.FIRST])
        assertEquals(2, lottoRankCount[LottoRank.SECOND])
        assertEquals(3, lottoRankCount[LottoRank.THIRD])
        assertEquals(4, lottoRankCount[LottoRank.FOURTH])
        assertEquals(0, lottoRankCount[LottoRank.MISS])
    }
}
