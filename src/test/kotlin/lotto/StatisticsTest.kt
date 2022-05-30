package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class StatisticsTest {
    @ParameterizedTest
    @MethodSource("statisticsCountTest")
    fun `당첨 금액별 당첨 갯수 계산해서 결과 리턴`(winnings: List<Winning>, expect: Map<Winning, Int>) {
        val result = Statistics.getWinningResult(winnings)
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `총 수익률 계산 후 리턴`() {
        // given
        val winning = mapOf(
            Winning.FIRST to 0,
            Winning.SECOND to 0,
            Winning.THIRD to 0,
            Winning.FOURTH to 1,
            Winning.FAIL to 13
        )

        // when
        val result = Statistics.getYield(winning, Price(1000 * 14))

        // then
        assertThat(result).isEqualTo(5000 / 14000.0)
    }

    companion object {
        @JvmStatic
        private fun statisticsCountTest(): List<Arguments> {
            return listOf(
                Arguments.of(
                    listOf(Winning.FIRST, Winning.SECOND, Winning.FAIL),
                    mapOf(
                        Winning.FIRST to 1,
                        Winning.SECOND to 1,
                        Winning.THIRD to 0,
                        Winning.FOURTH to 0
                    )
                ),
                Arguments.of(
                    listOf(Winning.FIRST, Winning.FIRST, Winning.FAIL),
                    mapOf(
                        Winning.FIRST to 2,
                        Winning.SECOND to 0,
                        Winning.THIRD to 0,
                        Winning.FOURTH to 0
                    )
                )
            )
        }
    }
}
