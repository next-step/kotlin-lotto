package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun `당첨 확인`(winners: List<Int>, bonus: Int, numbers: List<Int>, rank: LottoRank) {
        val winnerNumber = WinnerNumber(winners, bonus)
        val lottoNumber = LottoNumber(numbers)
        val matchRank = LottoRank.matchRank(winnerNumber, lottoNumber)
        assertThat(matchRank).isEqualTo(rank)
    }

    companion object {
        @JvmStatic private fun arguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 5, 17), LottoRank.THIRD),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 15, 17), LottoRank.FOURTH),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 14, 15, 17), LottoRank.FIFTH),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 13, 14, 15, 17), LottoRank.NONE),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 12, 13, 14, 15, 17), LottoRank.NONE),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(11, 12, 13, 14, 15, 17), LottoRank.NONE)
            )
        }
    }
}
