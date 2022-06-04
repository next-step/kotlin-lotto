package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningTest {
    @ParameterizedTest
    @MethodSource("winningTest")
    fun `일치 갯수에 따라 당첨 금액을 반환`(count: Int, expect: Winning, isMatchBonusNumber: Boolean) {
        assertThat(Winning.of(count, isMatchBonusNumber)).isEqualTo(expect)
    }

    companion object {
        @JvmStatic
        private fun winningTest(): List<Arguments> {
            return listOf(
                Arguments.of(6, Winning.FIRST, false),
                Arguments.of(5, Winning.SECOND, true),
                Arguments.of(5, Winning.THIRD, false),
                Arguments.of(4, Winning.FOURTH, false),
                Arguments.of(3, Winning.FIFTH, false),
                Arguments.of(2, Winning.FAIL, false),
                Arguments.of(1, Winning.FAIL, false),
                Arguments.of(0, Winning.FAIL, false),
            )
        }
    }
}
