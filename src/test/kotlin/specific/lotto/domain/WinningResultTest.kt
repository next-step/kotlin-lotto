package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningResultTest {

    @ParameterizedTest
    @MethodSource("provideSourceOfRank")
    fun `당첨 결과들은 등수별로 집계된다`(rank: Rank) {
        // given,
        val ranks = listOf(rank)

        // when
        val winningResult = WinningResult(ranks)

        // then
        assertEquals(1, winningResult.aggregatedData[rank])
    }

    @ParameterizedTest
    @MethodSource("provideSourceOfRank")
    fun `당첨자는 등수에 따라 상금을 받는다`(rank: Rank) {
        // given,
        val ranks = listOf(rank)
        val winningResult = WinningResult(ranks)

        // when
        val prize = winningResult.totalPrize

        // then
        assertEquals(rank.prize, prize)
    }

    companion object {
        @JvmStatic
        fun provideSourceOfRank() = Rank.values().map { Arguments.of(it) }
    }
}
