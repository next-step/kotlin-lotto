package lotto.enums

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RankTest {

    @ParameterizedTest
    @MethodSource("rankProvider")
    fun `번호 일치 수와 보너스번호 일치여부를 주입받아 랭크를 반환한다`(
        matchCount: Int,
        isMatchBonus: Boolean,
        expectedRank: Rank,
    ) {
        // Given & When
        val actual = Rank.valueOf(matchCount, isMatchBonus)

        // Then
        assertThat(actual).isEqualTo(expectedRank)
    }

    companion object {
        @JvmStatic
        fun rankProvider() = listOf(
            Arguments.of(3, false, Rank.FOURTH_RANK),
            Arguments.of(4, false, Rank.THIRD_RANK),
            Arguments.of(5, false, Rank.SECOND_RANK),
            Arguments.of(5, true, Rank.SECOND_BONUS_RANK),
            Arguments.of(6, false, Rank.FIRST_RANK),
            Arguments.of(0, false, Rank.NONE_RANK),
        )
    }
}
