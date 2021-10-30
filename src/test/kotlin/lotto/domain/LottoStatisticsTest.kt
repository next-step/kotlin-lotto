package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoStatisticsTest {

    @Test
    @DisplayName("수익률 총상금/구매금액 (구매금액 1000원 당첨금 10000원)")
    fun `수익률 총상금 나누기 구매금액 (구매금액 1000원 당첨금 10000원)`() {
        val statistics = LottoStatistics(
            1000,
            listOf(),
            10000
        )
        val expected = 10.0

        assertEquals(expected, statistics.getYield())
    }

    @Test
    @DisplayName("수익률 총상금/구매금액 (구매금액 2000원 당첨금 10000원)")
    fun `수익률 총상금 나누기 구매금액 (구매금액 2000원 당첨금 10000원)`() {
        val statistics = LottoStatistics(
            2000,
            listOf(),
            10000
        )
        val expected = 5.0

        assertEquals(expected, statistics.getYield())
    }
}
