package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoEarningRateTest {
    private val sut = LottoEarningRate

    @Test
    fun `sut calculate earning rate`() {
        // Arrange
        val boughtPrice = 14_000
        val ranks = listOf(
            Rank.FOURTH,
            Rank.THIRD
        )

        // Act
        val earningRate = sut.calculateEarningRate(boughtPrice, ranks)

        // Assert
        assertThat(earningRate).isEqualTo(3.93)
    }
}
