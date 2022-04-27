package lotto.domain.matching

import lotto.domain.matching.LottoMatching.Companion.ERR_INVALID_MATCHING_COUNT
import lotto.domain.matching.LottoMatching.FIRST_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.FOURTH_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.LAST_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.SECOND_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.THIRD_PLACE_MATCHING
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@DisplayName("로또 복권 게임 내 숫자 일치 개수를 의미하는 Enum 객체 `LottoMatching` 테스트")
internal class LottoMatchingTest {

    @DisplayName("유효 범위의 맞은 개수가 주어지면 해당되는 `LottoMatching` enum 반환")
    @ParameterizedTest
    @MethodSource("validMatchingCountAndExpectedLottoMatchingValues")
    fun `return LottoMatching enum class if given valid matching count`(givenMatchingCount: Int, expectedLottoMatching: LottoMatching) {
        // Arrange
        // Act
        val lottoMatching = LottoMatching.from(givenMatchingCount)

        // Assert
        assertThat(lottoMatching).isEqualTo(expectedLottoMatching)
    }

    @DisplayName("맞은 개수가 0부터 2 사이 값으로 주어지면 `LAST_PLACE_MATCHING` 반환")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `return LAST_PLACE_MATCHING enum class if given matching count in the range zero to two`(givenMatchingCount: Int) {
        // Arrange
        // Act
        val lottoMatching = LottoMatching.from(givenMatchingCount)

        // Assert
        assertThat(lottoMatching).isEqualTo(LAST_PLACE_MATCHING)
    }

    @DisplayName("유효 범위에 포함되지 않은 맞은 개수가 주어지면 `IllegalArgumentException` 발생")
    @ParameterizedTest
    @ValueSource(ints = [-1, 7])
    fun `throw IllegalArgumentException if given invalid matching count`(invalidMatchingCount: Int) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy() {
            LottoMatching.from(invalidMatchingCount)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERR_INVALID_MATCHING_COUNT)
    }

    companion object {
        @JvmStatic
        fun validMatchingCountAndExpectedLottoMatchingValues(): Stream<Arguments> =
            Stream.of(
                Arguments.of(6, FIRST_PLACE_MATCHING),
                Arguments.of(5, SECOND_PLACE_MATCHING),
                Arguments.of(4, THIRD_PLACE_MATCHING),
                Arguments.of(3, FOURTH_PLACE_MATCHING),
                Arguments.of(0, LAST_PLACE_MATCHING)
            )
    }
}
