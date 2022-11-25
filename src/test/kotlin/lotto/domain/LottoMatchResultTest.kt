package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMatchResultTest {

    @Test
    fun getMatchResult() {
        val lottoMatchMap = mutableMapOf<LottoRank, LottoMatch>()
        val matchCount = 3L
        val lottoRank = LottoRank.FOURTH_PLACE
        lottoMatchMap[lottoRank] = LottoMatch(lottoRank, matchCount)

        val lottoMatchList =
            LottoMatchResult(lottoMatchMap).getMatchResult()

        lottoMatchList.forEach { lottoMatch ->
            assertThat(lottoMatch.lottoRank).isEqualTo(lottoRank)
            assertThat(lottoMatch.matchTotalCount).isEqualTo(matchCount)
        }
    }

    @Test
    fun `setMatchResult should matchCount + 1`() {
        val lottoMatchMap = mutableMapOf<LottoRank, LottoMatch>()
        val matchCount = 6
        val matchTotalCount = 2L
        val lottoRank = LottoRank.FIRST_PLACE
        lottoMatchMap[lottoRank] = LottoMatch(lottoRank, matchTotalCount)

        val lottoMatchResult = LottoMatchResult(lottoMatchMap)
        lottoMatchResult.setMatchResult(matchCount)

        lottoMatchResult.getMatchResult().forEach { lottoMatch ->
            assertThat(lottoMatch.lottoRank.matchCount).isEqualTo(matchCount)
            assertThat(lottoMatch.matchTotalCount).isEqualTo(matchTotalCount + 1)
        }
    }
}
