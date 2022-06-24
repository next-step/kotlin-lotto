package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoWinnerRankTest {

    @ParameterizedTest
    @MethodSource("matchCountAndBonusAndRank")
    fun `로또 등수를 반환한다`(matchCount: Int, bonus: Boolean, rank: LottoWinnerRank) {
        assertThat(LottoWinnerRank.of(matchCount, bonus)).isEqualTo(rank)
    }

    companion object {
        @JvmStatic
        fun matchCountAndBonusAndRank(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(6, false, LottoWinnerRank.FIRST_PRICE),
                Arguments.of(6, true, LottoWinnerRank.FIRST_PRICE),
                Arguments.of(5, false, LottoWinnerRank.THIRD_PRICE),
                Arguments.of(5, true, LottoWinnerRank.SECOND_PRICE),
                Arguments.of(4, false, LottoWinnerRank.FOURTH_PRICE),
                Arguments.of(4, true, LottoWinnerRank.FOURTH_PRICE),
                Arguments.of(3, false, LottoWinnerRank.FIFTH_PRICE),
                Arguments.of(3, true, LottoWinnerRank.FIFTH_PRICE),
                Arguments.of(2, false, LottoWinnerRank.NONE),
                Arguments.of(2, true, LottoWinnerRank.NONE),
                Arguments.of(1, false, LottoWinnerRank.NONE),
                Arguments.of(1, true, LottoWinnerRank.NONE),
                Arguments.of(0, false, LottoWinnerRank.NONE),
                Arguments.of(0, true, LottoWinnerRank.NONE),
            )
        }
    }
}
