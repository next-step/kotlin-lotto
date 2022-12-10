package lotto

import lotto.domain.*
import lotto.domain.Lotto
import lotto.domain.WinningMachine
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WinningMachineTest {

    @ParameterizedTest
    @MethodSource("lottoTestFixture")
    fun `로또 번호가 몇개 일치하는지 비교한다`(rank: Rank, numbers: List<Int>) {
        val winLotto = WinLotto(Lotto(listOf(1, 2, 3, 7, 10, 41)), LottoNum.of(9))
        val lotto = Lotto(numbers)
        val winningMachine = WinningMachine(winLotto)
        val result = winningMachine.match(listOf(lotto))
        assertThat(result.from(rank)).contains(lotto)
    }

    companion object {

        @JvmStatic
        fun lottoTestFixture(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Rank.FIFTH, listOf(1, 2, 3, 8, 11, 42)),
                Arguments.of(Rank.FOURTH, listOf(1, 2, 3, 7, 11, 42)),
                Arguments.of(Rank.THIRD, listOf(1, 2, 3, 7, 11, 41)),
                Arguments.of(Rank.THIRD, listOf(1, 2, 3, 7, 11, 41)),
                Arguments.of(Rank.SECOND, listOf(1, 2, 3, 7, 9, 41)),
                Arguments.of(Rank.FIRST, listOf(1, 2, 3, 7, 10, 41))
            )
        }
    }

}