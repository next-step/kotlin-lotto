package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `수익 계산`() {
        val lottoNumber = LottoNumber(1, 2, 3, 4, 5, 6)
        val prizeNumber = LottoNumber(3, 4, 5, 6, 7, 8)

        val machine = LottoMachine()
        val prizeStat = machine.calculateStat(listOf(lottoNumber), prizeNumber)
        val profit = machine.calculateProfit(prizeStat)

        assertThat(profit).isEqualTo(5000)
    }
}
