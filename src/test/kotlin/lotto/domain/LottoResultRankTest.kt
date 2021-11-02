package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoResultRankTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `일치 개수가 0~2개 인 경우 MISSED LottoResultRank 를 반환한다`(input: Int) {
        val rankKey = LottoResultRankKey(MatchedCount.of(input))
        val rank = LottoResultRank.getRank(rankKey.matchedCount, rankKey.matchedBonusNumber)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.MISSED)
    }

    @Test
    fun `일치 개수가 3개 인 경우 FIFTH LottoResultRank 를 반환한다`() {
        val rankKey = LottoResultRankKey(MatchedCount.of(3))
        val rank = LottoResultRank.getRank(rankKey.matchedCount, rankKey.matchedBonusNumber)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.FIFTH)
    }

    @Test
    fun `일치 개수가 4개 인 경우 FOURTH LottoResultRank 를 반환한다`() {
        val rankKey = LottoResultRankKey(MatchedCount.of(4))
        val rank = LottoResultRank.getRank(rankKey.matchedCount, rankKey.matchedBonusNumber)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.FOURTH)
    }

    @Test
    fun `일치 개수가 5개에 보너스 번호가 일치하지 않을 경우 THIRD LottoResultRank 를 반환한다`() {
        val rankKey = LottoResultRankKey(MatchedCount.of(5))
        val rank = LottoResultRank.getRank(rankKey.matchedCount, rankKey.matchedBonusNumber)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.THIRD)
    }

    @Test
    fun `일치 개수가 5개에 보너스 번호가 일치하는 않을 경우 SECOND LottoResultRank 를 반환한다`() {
        val rankKey = LottoResultRankKey(MatchedCount.of(5), true)
        val rank = LottoResultRank.getRank(rankKey.matchedCount, rankKey.matchedBonusNumber)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.SECOND)
    }

    @Test
    fun `일치 개수가 6개 인 경우 FIRST LottoResultRank 를 반환한다`() {
        val rankKey = LottoResultRankKey(MatchedCount.of(6))
        val rank = LottoResultRank.getRank(rankKey.matchedCount, rankKey.matchedBonusNumber)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.FIRST)
    }
}
