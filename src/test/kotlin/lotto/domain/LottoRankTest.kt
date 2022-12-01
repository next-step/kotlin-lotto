package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoRankTest {

    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5, 6])
    fun `valueOf return LottoRank`(matchCount: Int) {
        val isBonus = false
        val lottoRank = LottoRank.valueOf(matchCount, isBonus)

        assertThat(lottoRank.matchCount).isEqualTo(matchCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, Int.MAX_VALUE])
    fun `valueOf return MISS when matchCount not in 3~6`(matchCount: Int) {
        val isBonus = false
        val lottoRank = LottoRank.valueOf(matchCount, isBonus)

        assertThat(lottoRank).isEqualTo(LottoRank.MISS)
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `valueOf return FOURTH_PLACE when matchCount 4`(isBonus: Boolean) {
        val matchCount = 4
        val lottoRank = LottoRank.valueOf(matchCount, isBonus)

        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH_PLACE)
    }

    @Test
    fun `valueOf return THIRD_PLACE when matchCount 6 and isBonus is false`() {
        val isBonus = false
        val matchCount = 5
        val lottoRank = LottoRank.valueOf(matchCount, isBonus)

        assertThat(lottoRank).isEqualTo(LottoRank.THIRD_PLACE)
    }

    @Test
    fun `valueOf return SECOND_PLACE when matchCount 6 and isBonus is true`() {
        val isBonus = true
        val matchCount = 5
        val lottoRank = LottoRank.valueOf(matchCount, isBonus)

        assertThat(lottoRank).isEqualTo(LottoRank.SECOND_PLACE)
    }

    @Test
    fun getMissing() {
        val lottoRankList = setOf(LottoRank.THIRD_PLACE, LottoRank.SECOND_PLACE)
        val missingResult = LottoRank.getMissing(lottoRankList)

        val result = setOf(LottoRank.MISS, LottoRank.FOURTH_PLACE, LottoRank.FIRST_PLACE, LottoRank.FIFTH_PLACE)
        assertThat(missingResult).isEqualTo(result)
    }
}
