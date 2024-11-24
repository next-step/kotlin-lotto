package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("provideLottoRankMapper")
    fun `of 함수는 정확히 LottoRank에 매핑해야 한다`(input: Pair<Int, LottoRank>) {
        assertThat(LottoRank.of(input.first)).isEqualTo(input.second)
    }

    @ParameterizedTest
    @MethodSource("provideUnknownMatchCount")
    fun `예상치 못한 matchCount를 호출하면 None을 반환해야 한다`(input: Int) {
        assertThat(LottoRank.of(input)).isEqualTo(LottoRank.NONE)
    }

    companion object {
        @JvmStatic
        fun provideLottoRankMapper(): List<Pair<Int, LottoRank>> {
            return listOf(
                6 to LottoRank.FIRST,
                5 to LottoRank.SECOND,
                4 to LottoRank.THIRD,
                3 to LottoRank.FOURTH,
            )
        }

        @JvmStatic
        fun provideUnknownMatchCount(): List<Int> {
            return listOf(
                7,
                2,
                0,
            )
        }
    }

}
