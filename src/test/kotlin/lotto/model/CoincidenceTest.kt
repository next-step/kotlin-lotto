package lotto.model

import lotto.model.result.Coincidence
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CoincidenceTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `로또 한 개와 당첨로또와 일치하는 번호 수와 보너스번호 포함여부를 전달하면 Result를 알 수 있다`(
        expected: Coincidence,
        matchedCount: Int,
        hasBonusNum: Boolean
    ) {
        // when
        val actual = Coincidence.match(matchedCount, hasBonusNum)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(Coincidence.FIRST, 6, false),
                Arguments.arguments(Coincidence.FIRST, 6, true),
                Arguments.arguments(Coincidence.SECOND, 5, true),
                Arguments.arguments(Coincidence.THIRD, 5, false),
                Arguments.arguments(Coincidence.FOURTH, 4, true),
                Arguments.arguments(Coincidence.FOURTH, 4, false),
                Arguments.arguments(Coincidence.FIFTH, 3, true),
                Arguments.arguments(Coincidence.FIFTH, 3, false)
            )
        }
    }
}
