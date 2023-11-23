package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LotteriesTest {
    @ParameterizedTest
    @MethodSource("arrangeWinningResultTest")
    fun `로또 당첨결과를 반환한다`(lotteries: Lotteries, winningNumbers: List<Int>, expected: WinningResult) {
        assertThat(lotteries.winningResult(Numbers(winningNumbers))).isEqualTo(expected)
    }

    @Test
    fun `로또 개수 확인`() {
        val lotteries = Lotteries(listOf(Lottery(), Lottery()))
        val actual = lotteries.size()
        assertThat(actual).isEqualTo(2)
    }

    companion object {
        @JvmStatic
        fun arrangeWinningResultTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Lotteries(listOf(Lottery(Numbers(listOf(1, 2, 3, 4, 5, 6))))),
                    listOf(1, 2, 3, 4, 5, 6),
                    WinningResult().apply { recordPrize(Prize.FIRST_PRIZE) }
                ),
                Arguments.of(
                    Lotteries(listOf(Lottery(Numbers(listOf(1, 2, 3, 4, 5, 6))))),
                    listOf(1, 2, 3, 4, 5, 7),
                    WinningResult().apply { recordPrize(Prize.SECOND_PRIZE) }
                ),
                Arguments.of(
                    Lotteries(listOf(Lottery(Numbers(listOf(1, 2, 3, 4, 5, 6))))),
                    listOf(1, 2, 3, 4, 7, 8),
                    WinningResult().apply { recordPrize(Prize.THIRD_PRIZE) }
                ),
                Arguments.of(
                    Lotteries(listOf(Lottery(Numbers(listOf(1, 2, 3, 4, 5, 6))))),
                    listOf(1, 2, 3, 7, 8, 9),
                    WinningResult().apply { recordPrize(Prize.FOURTH_PRIZE) }
                ),
                Arguments.of(
                    Lotteries(listOf(Lottery(Numbers(listOf(1, 2, 3, 4, 5, 6))))),
                    listOf(1, 2, 7, 8, 9, 10),
                    WinningResult().apply { recordPrize(Prize.NONE) }
                ),
            )
        }
    }
}
