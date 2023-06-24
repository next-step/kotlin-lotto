package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoRankTest {

    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6])
    @ParameterizedTest
    fun getByMatchCount(matchCount: Int) {
        // when
        val lottoRank = LottoRank.getByMatchCount(matchCount)

        // then
        assertThat(lottoRank).isEqualTo(
            when(matchCount) {
                0 -> LottoRank.NONE
                1 -> LottoRank.NONE
                2 -> LottoRank.NONE
                3 -> LottoRank.FOURTH
                4 -> LottoRank.THIRD
                5 -> LottoRank.SECOND
                6 -> LottoRank.FIRST
                else -> {}
            }
        )
    }
}
