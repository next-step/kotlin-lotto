package lotto.domain.result

import lotto.domain.createLottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoRankTest {
    @DisplayName("일치 개수 리스트를 인자로 받아 해당하는 LottoRank 리스트를 반환")
    @Test
    fun rank() {
        val matchInfo = listOf(6, 5, 4, 3, 2, 1).map { MatchInfo.of(it, false) }
        val expected = createLottoResult()
        expected[LottoRank.FIRST] = 1
        expected[LottoRank.SECOND] = 1
        expected[LottoRank.THIRD] = 1
        expected[LottoRank.FOURTH] = 1
        expected[LottoRank.NONE] = 2

        val actual = LottoRank.rank(matchInfo)

        assertThat(actual.result).isEqualTo(expected)
    }
}
