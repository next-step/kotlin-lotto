package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RanksTest {
    @Test
    @DisplayName("수익률을 계산한다")
    fun `sut calculate earning rate`() {
        // Arrange
        val boughtPrice = 14_000
        val ranks = listOf(
            Rank.FOURTH,
            Rank.THIRD
        )
        val sut = Ranks(ranks = ranks)

        // Act
        val earningRate = sut.calculateEarningRate(boughtPrice)

        // Assert
        assertThat(earningRate).isEqualTo(3.93)
    }
}
