package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningTest {
    @ParameterizedTest
    @MethodSource("winningTest")
    fun `일치 갯수에 따라 당첨 금액을 반환`(count: Int, expect: Winning) {
        assertThat(Winning.of(count)).isEqualTo(expect)
    }

    companion object {
        @JvmStatic
        private fun winningTest(): List<Arguments> {
            return listOf(
                Arguments.of(6, Winning.FIRST),
                Arguments.of(5, Winning.SECOND),
                Arguments.of(4, Winning.THIRD),
                Arguments.of(3, Winning.FOURTH),
                Arguments.of(2, Winning.FAIL),
                Arguments.of(1, Winning.FAIL),
                Arguments.of(0, Winning.FAIL),
            )
        }
    }
}
