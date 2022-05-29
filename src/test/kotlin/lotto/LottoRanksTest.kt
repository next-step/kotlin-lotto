package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
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
    fun `통계 확인하기 LOSE 상태는 제외`() {
        assertAll("lotto ranks 값 확인", {
            assertThat(lottoRanks.getRanks().keys.size).isEqualTo(4)
            assertThat(lottoRanks.getRanks().keys).doesNotContain(LottoRank.LOSE)
        })
    }

    @Test
    fun `현재 당첨금 확인`() {
        lottoRanks.add(LottoRank.THREE_MATCH)

        assertThat(lottoRanks.getWinPrice()).isEqualTo(BigDecimal(5_000))
    }
}
