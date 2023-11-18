package lotto

import lotto.domain.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoRankTest {

    @ParameterizedTest
    @CsvSource("0, MISS", "3, FOURTH", "4, THIRD", "5, SECOND", "6, FIRST")
    fun `matchCount 개수에 맞는 Rank를 반환한다`(count: Int, expected: LottoRank) {
        val lottoRank: LottoRank = LottoRank.findByMatchCount(count)

        assertThat(lottoRank).isEqualTo(expected)
    }
}
