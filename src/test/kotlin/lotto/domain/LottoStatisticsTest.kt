package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStatisticsTest {
    @Test
    fun countMatchingNumbersTest() {
        val lastWinningNumber = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumberArray = listOf(listOf(1, 2, 3, 7, 8, 9))
        val resultMap = mutableMapOf(
            3 to 1,
            4 to 0,
            5 to 0,
            6 to 0
        )
        assertThat(LottoStatistics.getLottoWinnerList(lastWinningNumber, lottoNumberArray)).isEqualTo(resultMap)
    }

    @Test
    fun getRateOfReturnTest() {
        val resultMap = mutableMapOf(
            3 to 1,
            4 to 0,
            5 to 0,
            6 to 0
        )
        val amount = 10000
        assertThat(LottoStatistics.getRateOfReturn(resultMap, amount)).isEqualTo(0.5f)
    }
}
