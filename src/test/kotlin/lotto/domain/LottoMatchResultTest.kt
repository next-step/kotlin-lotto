package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(longs = [-1, 1, 2, 4, 100])
    fun `setMatchResult should matchCount + 1 when matchCount and isBonus matches LottoRank`(matchTotalCount: Long) {
        val lottoMatchMap = mutableMapOf<LottoRank, LottoMatch>()
        val lottoRank = LottoRank.FIRST_PLACE
        lottoMatchMap[lottoRank] = LottoMatch(lottoRank, matchTotalCount)

        val lottoMatchResult = LottoMatchResult(lottoMatchMap)
        val matchCount = lottoRank.matchCount
        val isBonus = lottoRank.isBonus
        lottoMatchResult.setMatchResult(matchCount, isBonus)

        lottoMatchResult.getMatchResult().forEach { lottoMatch ->
            assertThat(lottoMatch.lottoRank).isEqualTo(lottoRank)
            assertThat(lottoMatch.isBonusNumber).isEqualTo(isBonus)
            assertThat(lottoMatch.matchTotalCount).isEqualTo(matchTotalCount + 1)
        }
    }

    @ParameterizedTest
    @ValueSource(longs = [-1, 1, 2, 4, 100])
    fun `matchCount does not change when matchCount and isBonus not match LottoRank`(matchTotalCount: Long) {
        val lottoMatchMap = mutableMapOf<LottoRank, LottoMatch>()
        val lottoRank = LottoRank.FIRST_PLACE
        lottoMatchMap[lottoRank] = LottoMatch(lottoRank, matchTotalCount)

        val lottoMatchResult = LottoMatchResult(lottoMatchMap)
        val otherLottRank = LottoRank.SECOND_PLACE
        val matchCount = otherLottRank.matchCount
        val isBonus = otherLottRank.isBonus
        lottoMatchResult.setMatchResult(matchCount, isBonus)

        lottoMatchResult.getMatchResult().forEach { lottoMatch ->
            assertThat(lottoMatch.lottoRank).isEqualTo(lottoRank)
            assertThat(lottoMatch.isBonusNumber).isEqualTo(false)
            assertThat(lottoMatch.matchTotalCount).isEqualTo(matchTotalCount)
        }
    }
}
