package lottoTest

import lotto.domain.Lotto
import lotto.domain.LottoStatCalculator
import lotto.domain.LottoStatResult
import lotto.domain.Rank
import lotto.domain.WinningLotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoStatCalculatorTest {

    @ParameterizedTest
    @MethodSource("generateLottoStatArguments")
    fun `당첨 통계 계산`(winningLotto: WinningLotto, input: List<Lotto>, expected: LottoStatResult) {
        val result = LottoStatCalculator(winningLotto).getStat(input)

        Rank.values().forEach {
            assertEquals(expected.getCount(it), result.getCount(it))
        }
    }

    companion object {
        @JvmStatic
        fun generateLottoStatArguments(): List<Arguments> {
            return listOf(
                Arguments.of(
                    WinningLotto(
                        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        bonusNumber = 45
                    ),
                    listOf(
                        Lotto(numbers = listOf(4, 5, 6, 10, 11, 12)),
                    ),
                    LottoStatResult(
                        mapOf(
                            Pair(Rank.FIRST, 0),
                            Pair(Rank.SECOND, 0),
                            Pair(Rank.THIRD, 0),
                            Pair(Rank.FOURTH, 0),
                            Pair(Rank.FIFTH, 1),
                            Pair(Rank.MISS, 0),
                        )
                    )
                ),
                Arguments.of(
                    WinningLotto(
                        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        bonusNumber = 45
                    ),
                    listOf(
                        Lotto(numbers = listOf(1, 2, 3, 4, 5, 45)),
                    ),
                    LottoStatResult(
                        mapOf(
                            Pair(Rank.FIRST, 0),
                            Pair(Rank.SECOND, 1),
                            Pair(Rank.THIRD, 0),
                            Pair(Rank.FOURTH, 0),
                            Pair(Rank.FIFTH, 0),
                            Pair(Rank.MISS, 0),
                        )
                    )
                ),
                Arguments.of(
                    WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), bonusNumber = 45),
                    listOf(
                        Lotto(numbers = listOf(1, 2, 3, 4, 5, 6)),
                        Lotto(numbers = listOf(1, 2, 3, 4, 5, 7)),
                        Lotto(numbers = listOf(1, 2, 3, 4, 7, 8)),
                    ),
                    LottoStatResult(
                        mapOf(
                            Pair(Rank.FIRST, 1),
                            Pair(Rank.SECOND, 0),
                            Pair(Rank.THIRD, 1),
                            Pair(Rank.FOURTH, 1),
                            Pair(Rank.FIFTH, 0),
                            Pair(Rank.MISS, 0),
                        )
                    )
                ),
            )
        }
    }
}
