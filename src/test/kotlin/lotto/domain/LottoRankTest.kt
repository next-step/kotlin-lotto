package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoRankTest {

    @ParameterizedTest
    @ValueSource(ints = [Int.MIN_VALUE, 0, 1, 2, 7, Int.MAX_VALUE])
    fun `getReward should be zero when matchCount is not in 3~6`(matchCount: Int) {
        val resultReward = LottoRank.getReward(matchCount)

        assertThat(resultReward).isEqualTo(0L)
    }

    @Test
    fun getRewardTest() {
        val resultReward = LottoRank.getReward(6)

        assertThat(resultReward).isEqualTo(2000000000)
    }

    @Test
    fun getMatchCountList() {
        val matchCountList = listOf(6, 5, 4, 3)
        val resultMatchCountList = LottoRank.getMatchCountList()
        assertThat(resultMatchCountList).isEqualTo(matchCountList)
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5, 6])
    fun `valueOf return LottoRank`(matchCount: Int) {
        val lottoRank = LottoRank.valueOf(matchCount)

        assertThat(lottoRank?.matchCount).isEqualTo(matchCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, Int.MAX_VALUE])
    fun `valueOf return null when matchCount not in 3~6`(matchCount: Int) {
        val lottoRank = LottoRank.valueOf(matchCount)

        assertThat(lottoRank).isNull()
    }
}
