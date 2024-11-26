package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("provideLottoRankTestParameter")
    fun `of 함수는 정확히 LottoRank에 매핑해야 한다`(input: Parameter) {
        assertThat(LottoRank.of(input.matchCount, input.matchBonus)).isEqualTo(input.result)
    }

    @ParameterizedTest
    @MethodSource("provideUnknownMatchCount")
    fun `예상치 못한 matchCount를 호출하면 None을 반환해야 한다`(input: Int) {
        assertThat(LottoRank.of(input, true)).isEqualTo(LottoRank.NONE)
    }

    companion object {
        @JvmStatic
        fun provideLottoRankTestParameter(): List<Parameter> {
            return listOf(
                Parameter(6, true, LottoRank.FIRST),
                Parameter(6, false, LottoRank.FIRST),
                Parameter(5, true, LottoRank.SECOND),
                Parameter(5, false, LottoRank.THIRD),
                Parameter(4, true, LottoRank.FOURTH),
                Parameter(4, false, LottoRank.FOURTH),
                Parameter(3, true, LottoRank.FIFTH),
                Parameter(3, false, LottoRank.FIFTH),
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

    data class Parameter(
        val matchCount: Int,
        val matchBonus: Boolean,
        val result: LottoRank,
    )

}
