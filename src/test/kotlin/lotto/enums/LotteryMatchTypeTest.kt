package lotto.enums

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LotteryMatchTypeTest {
    @Test
    fun findByMatchCount() {
        assertThat(LotteryMatchType.findByMatchCount(6)).isEqualTo(LotteryMatchType.Six)
        assertThat(LotteryMatchType.findByMatchCount(2)).isEqualTo(LotteryMatchType.NonProfit)
    }
}
