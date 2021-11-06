package lotto.domain

import lotto.exception.InvalidLottoNumberException
import lotto.exception.InvalidWinningNumberException
import lotto.fixture.LottoNumberFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("당첨 번호 테스트")
class WinningNumberTest {

    @Test
    @DisplayName("6개의 당첨번호를 입력받을 수 있고, 방어적 복사로 외부 값의 변경을 제한한다")
    fun `sut returns correctly and apply defensive copy`() {
        // Arrange
        val inputWinningNumber = mutableListOf("1", "2", "3", "4", "5", "6")

        // Act
        val winningNumber = WinningNumber.of(inputWinningNumber, 45)

        // Assert
        assertThat(winningNumber.getLottoNumbers()).hasSize(6)

        inputWinningNumber.add("8")

        assertThat(winningNumber.getLottoNumbers()).hasSize(6)
    }

    @Test
    @DisplayName("당첨 번호에 로또 번호가 포함될 경우 true 반환")
    fun `sut returns true when winning number contains lotto numbers`() {
        // Arrange
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 8

        // Act
        val sut = WinningNumber.of(winningNumbers, bonusNumber)
        val result = sut.containsLottoNumber(LottoNumberFixture.create(1))

        // Assert
        assertThat(result).isTrue
    }

    @Test
    @DisplayName("당첨 번호에 로또 번호가 포함되어있지 않은 경우 false 반환")
    fun `sut returns false when winning number not contains lotto numbers`() {
        // Arrange
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = 8

        // Act
        val sut = WinningNumber.of(winningNumbers, bonusNumber)
        val result = sut.containsLottoNumber(LottoNumberFixture.create(45))

        // Assert
        assertThat(result).isFalse
    }

    @Test
    @DisplayName("입력된 당첨 번호가 없을 경우 예외 발생")
    fun `sut throw InvalidWinningNumberException when winning number is empty`() {
        // Arrange
        val inputWinningNumber = emptyList<String>()

        // Act, Assert
        assertThrows<InvalidWinningNumberException> { WinningNumber.of(inputWinningNumber, 45) }
    }

    @Test
    @DisplayName("입력된 당첨 번호의 개수가 6이 아닐 경우 예외 발생")
    fun `sut throw InvalidWinningNumberException when winning number size greater than 6`() {
        // Arrange
        val inputWinningNumber = listOf("1", "2", "3", "4", "5", "6", "7")

        // Act, Assert
        assertThrows<InvalidWinningNumberException> { WinningNumber.of(inputWinningNumber, 45) }
    }

    @Test
    @DisplayName("입력된 당첨 번호의 숫자 범위가 1 ~ 45를 벗어날 경우 예외 발생")
    fun `sut throw InvalidWinningNumberException when winning number range not in 1 ~ 45`() {
        // Arrange
        val inputWinningNumber = listOf("1", "2", "3", "4", "5", "46")

        // Act, Assert
        assertThrows<InvalidLottoNumberException> { WinningNumber.of(inputWinningNumber, 45) }
    }
}
