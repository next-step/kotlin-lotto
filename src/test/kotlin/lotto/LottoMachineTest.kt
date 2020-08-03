package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `수익 계산`() {

        val machine = LottoMachine()

        val prizeStat = mapOf(Pair(4, 1))
        val profit = machine.calculateProfit(prizeStat)

        assertThat(profit).isEqualTo(5000)
    }

    @Test
    fun `등수 목록 계산`() {
        val lottoNumber1 = LottoNumber(1, 2, 3, 4, 5, 6)
        val lottoNumber2 = LottoNumber(3, 4, 5, 6, 7, 8)
        val prizeNumber = LottoNumber(3, 4, 5, 6, 7, 8)

        val machine = LottoMachine()
        val prizeStat = machine.calculateStat(listOf(lottoNumber1, lottoNumber2), prizeNumber)

        assertThat(prizeStat).containsEntry(6, 1)
        assertThat(prizeStat).containsEntry(4, 1)
    }
}
