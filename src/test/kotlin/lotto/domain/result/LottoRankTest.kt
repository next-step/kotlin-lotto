package lotto.domain.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoRankTest {
    @DisplayName("일치 개수를 인자로 받아 해당하는 LottoRank 반환")
    @ParameterizedTest
    @MethodSource("provideMatchInfoAndRank")
    fun from(matchInfo: MatchInfo, rank: LottoRank) {
        assertThat(LottoRank.from(matchInfo)).isEqualTo(rank)
    }

    companion object {
        @JvmStatic
        fun provideMatchInfoAndRank(): List<Arguments> = listOf(
            Arguments.of(MatchInfo.of(6, false), LottoRank.FIRST),
            Arguments.of(MatchInfo.of(5, true), LottoRank.SECOND),
            Arguments.of(MatchInfo.of(5, false), LottoRank.THIRD),
            Arguments.of(MatchInfo.of(4, false), LottoRank.FOURTH),
            Arguments.of(MatchInfo.of(3, false), LottoRank.FIFTH),
            Arguments.of(MatchInfo.of(2, false), LottoRank.NONE),
            Arguments.of(MatchInfo.of(1, false), LottoRank.NONE),
            Arguments.of(MatchInfo.of(0, false), LottoRank.NONE),
        )
    }
}
