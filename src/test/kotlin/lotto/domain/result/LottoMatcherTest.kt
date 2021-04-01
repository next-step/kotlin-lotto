package lotto.domain.result

import lotto.domain.createLottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoMatcherTest {
    @DisplayName("일치 개수 리스트를 인자로 받아 해당하는 LottoRank 리스트를 반환")
    @Test
    fun rank() {
        val matchInfo = listOf(
            MatchInfo.of(6, false),
            MatchInfo.of(5, true),
            MatchInfo.of(5, false),
            MatchInfo.of(4, false),
            MatchInfo.of(3, false),
            MatchInfo.of(2, false),
            MatchInfo.of(1, false),
        )
        val expected = createLottoResult()
        expected[LottoRank.FIRST] = 1
        expected[LottoRank.SECOND] = 1
        expected[LottoRank.THIRD] = 1
        expected[LottoRank.FOURTH] = 1
        expected[LottoRank.FIFTH] = 1
        expected[LottoRank.NONE] = 2

        val actual = LottoMatcher().rank(matchInfo)

        assertThat(actual.result).isEqualTo(expected)
    }
}
