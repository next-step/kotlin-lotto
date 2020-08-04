package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoMachineTest {

    @Test
    fun `수익 계산`() {

        val machine = LottoMachine()

        val prizeStat = PrizeMoneyWrapper(PrizeMoney.THREE, 1)
        val profit = machine.calculateProfit(listOf(prizeStat))

        assertThat(profit).isEqualTo(5000)
    }

    @ParameterizedTest
    @MethodSource("calculateStatNumbers")
    fun `등수 목록 계산`(prizeNumber: List<Int>, buyNumbers: List<Int>) {
        val prizeNumber = LottoNumber(prizeNumber)
        val buyNumber = LottoNumber(buyNumbers)

        val machine = LottoMachine()
        val prizeStat = machine.calculateStat(listOf(buyNumber), prizeNumber)

        assertThat(prizeStat).contains(
            PrizeMoneyWrapper(PrizeMoney.FIVE, 1)
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
