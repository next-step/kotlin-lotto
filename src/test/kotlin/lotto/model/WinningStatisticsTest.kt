package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("당첨 통계 테스트")
class WinningStatisticsTest {

    @ParameterizedTest
    @CsvSource(value = ["5000:1.0", "7500:0.66", "10000:0.5"], delimiter = ':')
    fun `수익률을 정상적으로 계산`(paymentPrice: Int, earningRatio: Double) {
        // given
        val statistics = WinningStatistics.from(listOf(WinningRank.FIFTH_PRIZE))

        // when, then
        assertEquals(statistics.calculateEarningRatio(paymentPrice), earningRatio)
    }
}
