package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LottoRankTest {
    @ParameterizedTest
    @MethodSource("매치카운트와 보너스볼 매치 여부로 등수를 구한다의 Arguments")
    fun `매치카운트와 보너스볼 매치 여부로 등수를 구한다`(matchCount: Int, matchBonus: Boolean, expectedRank: LottoRank) {
        assertThat(LottoRank.selectByMatchCount(matchCount, matchBonus)).isEqualTo(expectedRank)
    }

    companion object {
        @JvmStatic
        fun `매치카운트와 보너스볼 매치 여부로 등수를 구한다의 Arguments`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST_PLACE),
                Arguments.of(5, true, LottoRank.SECOND_PLACE),
                Arguments.of(5, false, LottoRank.THIRD_PLACE),
                Arguments.of(4, false, LottoRank.FORTH_PLACE),
                Arguments.of(3, false, LottoRank.FIFTH_PLACE)
            )
        }
    }

    @Test
    fun `매치되지 않는 등수를 제외한 값 테스트`() {
        val ranks = LottoRank.valuesNotIncludeNotPlace()
        assertThat(ranks).containsAll(
            listOf(
                LottoRank.FIRST_PLACE,
                LottoRank.SECOND_PLACE,
                LottoRank.THIRD_PLACE,
                LottoRank.FORTH_PLACE,
                LottoRank.FIFTH_PLACE
            )
        )
    }
}
