package lotto.domain.rank

import lotto.domain.matching.LottoMatching
import lotto.domain.matching.LottoMatching.FIRST_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.FOURTH_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.LAST_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.SECOND_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.THIRD_PLACE_MATCHING
import lotto.domain.rank.LottoRank.FIRST_PLACE
import lotto.domain.rank.LottoRank.FOURTH_PLACE
import lotto.domain.rank.LottoRank.LAST_PLACE
import lotto.domain.rank.LottoRank.SECOND_PLACE
import lotto.domain.rank.LottoRank.THIRD_PLACE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("로또 복권 게임의 랭크를 의미하는 Enum 객체 `LottoRank` 테스트")
internal class LottoRankTest {

    @DisplayName("올바른 `LottoMatching`이 주어지면 랭크 올바른 `LottoRank` 반환")
    @ParameterizedTest
    @MethodSource("validMatchingCountAndExpectedLottoRank")
    fun `return valid LottoRank if given valid matching count`(givenLottoMatching: LottoMatching, expectedLottoRank: LottoRank) {
        // Arrange
        // Act
        val lottoRank = LottoRank.from(givenLottoMatching)

        // Assert
        assertThat(lottoRank).isEqualTo(expectedLottoRank)
    }

    companion object {
        @JvmStatic
        fun validMatchingCountAndExpectedLottoRank(): Stream<Arguments> =
            Stream.of(
                Arguments.of(FIRST_PLACE_MATCHING, FIRST_PLACE),
                Arguments.of(SECOND_PLACE_MATCHING, SECOND_PLACE),
                Arguments.of(THIRD_PLACE_MATCHING, THIRD_PLACE),
                Arguments.of(FOURTH_PLACE_MATCHING, FOURTH_PLACE),
                Arguments.of(LAST_PLACE_MATCHING, LAST_PLACE),
            )
    }
}
