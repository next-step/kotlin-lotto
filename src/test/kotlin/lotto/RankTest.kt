package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RankTest {
    @Test
    @DisplayName("matchCount가 2개라면 LOSING을 반환해준다")
    fun `sut return LOSING when matchCount is 2`() {
        // Arrange

        // Act
        val rank = Rank.from(matchCount = 2, isBonus = false)

        // Assert
        assertThat(rank).isEqualTo(Rank.LOSING)
    }

    @Test
    @DisplayName("보너스볼을 이용해서 6개가 당첨된 경우라면 SECOND를 반환한다")
    fun `sut return SECOND when matchCount is 6 and isBonus`() {
        // Arrange

        // Act
        val rank = Rank.from(matchCount = 6, isBonus = true)

        // Assert
        assertThat(rank).isEqualTo(Rank.SECOND)
    }
}
