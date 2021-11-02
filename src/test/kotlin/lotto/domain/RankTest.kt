package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("당첨 결과 테스트")
class RankTest {

    @Test
    @DisplayName("당첨 번호 개수에 맞는 Rank 반환 (1등)")
    fun `sut returns rank first`() {
        // Arrange
        val matchCount = 6

        // Act
        val rank = Rank.valueOf(matchCount)

        // Assert
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    @DisplayName("당첨 번호 개수에 맞는 Rank 반환 (2등)")
    fun `sut returns rank second`() {
        // Arrange
        val matchCount = 5

        // Act
        val rank = Rank.valueOf(matchCount, true)

        // Assert
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    @DisplayName("당첨 번호 개수에 맞는 Rank 반환 (3등)")
    fun `sut returns rank third`() {
        // Arrange
        val matchCount = 5

        // Act
        val rank = Rank.valueOf(matchCount)

        // Assert
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    @DisplayName("당첨 번호를 맞춘 로또 번호가 3개 미만일 경우 Miss 반환")
    fun `sut returns miss`(matchCount: Int) {
        // Act
        val rank = Rank.valueOf(matchCount)

        // Assert
        assertThat(rank).isEqualTo(Rank.MISS)
    }

    @Test
    @DisplayName("당첨 Rank의 개수만큼 총 당첨 금액 반환")
    fun `sut returns total winning money`() {
        // Arrange
        val matchResultValue = 3

        // Act
        val totalWinningMoney = Rank.SECOND.getTotalWinningMoney(matchResultValue)

        // Assert
        assertThat(totalWinningMoney).isEqualTo(90_000_000)
    }
}
