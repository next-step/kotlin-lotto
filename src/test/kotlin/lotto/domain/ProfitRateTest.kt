package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("수익률 테스트")
class ProfitRateTest {

    @Test
    @DisplayName("로또 총 당첨 금액을 구한다")
    fun `sut returns total winning money`() {
        // Arrange
        val matchResult = mapOf<Rank, Int>(
            Rank.FIRST to 1,
            Rank.SECOND to 0,
            Rank.THIRD to 2,
            Rank.FOURTH to 5,
        )
        val price = 100_000

        // Act
        val sut = ProfitRate(matchResult, price)
        val totalWinningMoney = sut.getTotalWinningMoney()

        // Assert
        assertThat(totalWinningMoney).isEqualTo(2_000_125_000)
    }

    @Test
    @DisplayName("구입 금액 대비 당첨금액의 수익률을 계산한다")
    fun `sut returns profit rate`() {
        // Arrange
        val price = 14_000
        val totalWinningMoney = 5_000

        // Act
        val sut = ProfitRate(mapOf(), price)
        val profitRate = sut.calculateProfitRate(totalWinningMoney)

        // Assert
        assertThat(profitRate).isEqualTo(0.35)
    }
}
