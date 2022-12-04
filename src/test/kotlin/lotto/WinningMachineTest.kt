package lotto

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
    fun `로또 번호가 몇개 일치하는지 비교한다`(count:Int, numbers: List<Int>) {
        val winLotto = Lotto(listOf(1, 2, 3, 7, 10, 41))
        val lotto = Lotto(numbers)
        val winningMachine = WinningMachine(winLotto)
        val result = winningMachine.match(listOf(lotto))
        println(count)
        assertThat(result[count]).contains(lotto)
    }

    companion object {

        @JvmStatic
        fun lottoTestFixture(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(3, listOf(1, 2, 3, 8, 11, 42)),
                Arguments.of(4, listOf(1, 2, 3, 7, 11, 42)),
                Arguments.of(5, listOf(1, 2, 3, 7, 11, 41)),
                Arguments.of(6, listOf(1, 2, 3, 7, 10, 41))
            )
        }
    }

}