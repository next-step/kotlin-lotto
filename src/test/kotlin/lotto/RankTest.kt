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
        val rank = Rank.of(matchCount = 2)

        // Assert
        assertThat(rank).isEqualTo(Rank.LOSING)
    }
}
