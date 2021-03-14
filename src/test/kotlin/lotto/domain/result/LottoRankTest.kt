package lotto.domain.result

import lotto.domain.result.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoRankTest {
    @DisplayName("일치 개수 리스트를 인자로 받아 해당하는 LottoRank 리스트를 반환")
    @Test
    fun rank() {
        val matchCounts = listOf(6, 5, 4, 3, 2, 1)
        val expected =
            listOf(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.NONE, LottoRank.NONE)

        val actual = LottoRank.rank(matchCounts)

        assertThat(actual).isEqualTo(expected)
    }
}
