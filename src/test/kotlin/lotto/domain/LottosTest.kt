package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 관리 테스트")
class LottosTest {

    @Test
    @DisplayName("n개의 로또들의 당첨 결과를 수집할 수 있다")
    fun `sut returns match result`() {
        // Arrange
        val lottos = listOf(
            Lotto(listOf(3, 4, 5, 6, 7, 27)),
            Lotto(listOf(5, 7, 13, 27, 31, 45))
        )

        val winningNumber = WinningNumber(
            listOf("3", "5", "7", "13", "31", "45")
        )

        // Act
        val sut = Lottos(lottos)
        val result: Map<Rank, Int> = sut.matchWinningNumber(winningNumber.winningNumbers)

        // Assert
        assertThat(result[Rank.SECOND]).isEqualTo(1)
        assertThat(result[Rank.FOURTH]).isEqualTo(1)
    }
}
