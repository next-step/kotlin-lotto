package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 한개 단위 테스트")
class LottoTest {

    @Test
    @DisplayName("로또 번호에 당첨 번호가 포함되어 있으면 포함된 개수를 반환한다")
    fun `sut returns match count when lotto numbers contains winning number`() {
        // Arrange
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 7)

        // Act
        val sut = Lotto(lottoNumbers)
        val matchCount = sut.matchWinningNumber(winningNumbers)

        // Assert
        assertThat(matchCount).isEqualTo(5)
    }
}
