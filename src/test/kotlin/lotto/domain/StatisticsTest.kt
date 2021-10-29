package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class StatisticsTest {
    @DisplayName("수익율은 수익을 구입금액으로 나눈 값이어야 한다.")
    @Test
    fun calculateProfit() {
        val purchasePrice = 1000000000
        val profit = 2000000000 * 1 + 1500000 * 2 + 50000 * 3 + 5000 * 4
        assertThat(Fixture.statistics.calculateRatio(purchasePrice))
            .isEqualTo(profit.toDouble() / purchasePrice)
    }
}
