package lotto.domain

import lotto.exception.InvalidLottoNumberException
import lotto.exception.InvalidWinningNumberException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("당첨 번호 테스트")
class WinningNumberTest {

    @Test
    @DisplayName("6개의 당첨번호를 입력받을 수 있다")
    fun `sut returns correctly`() {
        // Arrange
        val inputWinningNumber = listOf("1", "2", "3", "4", "5", "6")

        // Act
        val winningNumber = WinningNumber(inputWinningNumber)

        // Assert
        assertThat(winningNumber.winningNumbers).hasSize(6)
    }

    @Test
    @DisplayName("입력된 당첨 번호가 없을 경우 예외 발생")
    fun `sut throw InvalidWinningNumberException when winning number is empty`() {
        // Arrange
        val inputWinningNumber = emptyList<String>()

        // Act, Assert
        assertThrows<InvalidWinningNumberException> { WinningNumber(inputWinningNumber) }
    }

    @Test
    @DisplayName("입력된 당첨 번호의 개수가 6이 아닐 경우 예외 발생")
    fun `sut throw InvalidWinningNumberException when winning number size greater than 6`() {
        // Arrange
        val inputWinningNumber = listOf("1", "2", "3", "4", "5", "6", "7")

        // Act, Assert
        assertThrows<InvalidWinningNumberException> { WinningNumber(inputWinningNumber) }
    }

    @Test
    @DisplayName("입력된 당첨 번호의 숫자 범위가 1 ~ 45를 벗어날 경우 예외 발생")
    fun `sut throw InvalidWinningNumberException when winning number range not in 1 ~ 45`() {
        // Arrange
        val inputWinningNumber = listOf("1", "2", "3", "4", "5", "46")

        // Act, Assert
        assertThrows<InvalidLottoNumberException> { WinningNumber(inputWinningNumber) }
    }
}
