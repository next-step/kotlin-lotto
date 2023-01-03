package lotto

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WinningLottoNumbersTest {
    @Test
    @DisplayName("보너스 번호는 우승번호가 될 수 없습니다")
    fun `sut bonus number can not be winning number`() {
        // Arrange
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        // Act & Assert
        assertThrows(IllegalArgumentException::class.java) {
            WinningLottoNumbers(numbers = lottoNumbers, bonusNumber = 1)
        }
    }
}
