package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal
import java.math.RoundingMode

class LotteryYieldTest {

    @ParameterizedTest
    @CsvSource(value = ["10000, 100000, 10", "1000, 10, 0.01"])
    fun `수익률을 계산할 수 있다`(paid: Int, rewards: Int, ratio: Double) {
        // given
        val userPaid = Money.of(paid)
        val totalRewards = Money.of(rewards)
        val expected = BigDecimal.valueOf(ratio).setScale(2, RoundingMode.FLOOR)

        // when
        val ratio = LotteryYield.of(userPaid, totalRewards).ratio

        // then
        Assertions.assertThat(ratio).isEqualTo(expected)
    }
}
