package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoMachineTest {

    @ParameterizedTest
    @MethodSource("calculateStatNumbers")
    fun `등수 목록 계산`(prizeNumber: List<Int>, buyNumbers: List<Int>) {
        val prizeNumber = Lotto(prizeNumber)
        val buyNumber = Lotto(buyNumbers)

        val machine = LottoMachine()
        val prizeStat = machine.calculateStat(listOf(buyNumber), prizeNumber)

        assertThat(prizeStat).contains(
            Pair(PrizeMoney.FIVE, 1)
        )
    }

    companion object {

        @JvmStatic
        fun calculateStatNumbers() = listOf<Arguments>(
            Arguments.of(
                listOf(1, 12, 43, 23, 39, 37),
                listOf(1, 12, 43, 23, 39, 42)
            )
        )
    }
}
