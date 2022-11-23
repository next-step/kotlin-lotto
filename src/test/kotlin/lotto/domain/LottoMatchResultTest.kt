package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMatchResultTest {

    @Test
    fun initTest() {
        val lottoMatchResult = LottoMatchResult()
        val resultMatchList = lottoMatchResult.getMatchResult()
        val matchNumberList = listOf<Int>(3, 4, 5, 6)

        resultMatchList.forEach { lottoMatch ->
            val reward = LottoRank.getReward(lottoMatch.matchNumber)

            assertThat(lottoMatch.matchNumber).isIn(matchNumberList)
            assertThat(lottoMatch.matchCount).isEqualTo(0L)
            assertThat(lottoMatch.reward).isEqualTo(reward)
        }
    }

    @Test
    fun getMatchResult() {
        val lottoMatchMap = mutableMapOf<Int, LottoMatch>()
        val matchNumber = 3
        val matchCount: Long = 2
        val reward: Long = 100
        lottoMatchMap[matchNumber] = LottoMatch(matchNumber, reward, matchCount)

        val lottoMatchList =
            LottoMatchResult(lottoMatchMap).getMatchResult()

        lottoMatchList.forEach { lottoMatch ->
            assertThat(lottoMatch.matchNumber).isEqualTo(matchNumber)
            assertThat(lottoMatch.matchCount).isEqualTo(matchCount)
            assertThat(lottoMatch.reward).isEqualTo(reward)
        }
    }

    @Test
    fun `setMatchResult should matchCount + 1`() {
        val lottoMatchMap = mutableMapOf<Int, LottoMatch>()
        val matchNumber = 3
        lottoMatchMap[matchNumber] = LottoMatch(matchNumber, 2, 0)

        val lottoMatchResult = LottoMatchResult(lottoMatchMap)
        lottoMatchResult.setMatchResult(matchNumber)

        lottoMatchResult.getMatchResult().forEach { lottoMatch ->
            assertThat(lottoMatch.matchNumber).isEqualTo(matchNumber)
            assertThat(lottoMatch.matchCount).isEqualTo(1)
        }
    }
}
