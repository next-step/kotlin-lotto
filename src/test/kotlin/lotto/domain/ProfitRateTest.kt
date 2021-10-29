package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("수익률 테스트")
class ProfitRateTest {

    @Test
    @DisplayName("구입 금액 대비 당첨금액의 수익률을 계산한다")
    fun `sut returns profit rate`() {
        // Arrange
        val matchResult = mapOf(
            Rank.FIRST to 0,
            Rank.SECOND to 0,
            Rank.THIRD to 0,
            Rank.FOURTH to 1,
        )
        val price = 14_000

        // Act
        val sut = ProfitRate(matchResult, price)
        val profitRate = sut.calculate()

        // Assert
        assertThat(profitRate).isEqualTo(0.35)
    }
}
