package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoStatisticsTest {

    @Test
    fun `1) 총 금액 계산하기`() {
        val lottoNumber = listOf(
            Lotto().also { it.getLottoNumber(listOf(3, 20, 4, 15, 4, 5)) }
        )
        Assertions.assertThat(LottoStatistics.calculateWinningTotalMoney(lottoNumber, listOf(3, 20, 4, 15, 4, 5))).isEqualTo(2000000000)
    }

    @Test
    fun `2) 수익률 계산하기`() {
        val lottoNumber = listOf(
            Lotto().also { it.getLottoNumber(listOf(3, 20, 4, 15, 11, 31)) }
        )
        val winningMoney = LottoStatistics.calculateWinningTotalMoney(lottoNumber, listOf(3, 20, 4, 5, 2, 34))
        Assertions.assertThat(LottoStatistics.calculateEarningRate(1000, winningMoney)).isEqualTo(5.0)
    }
}
