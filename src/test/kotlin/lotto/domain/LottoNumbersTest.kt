package lotto.domain

import lotto.exception.InvalidLottoNumberException
import lotto.fixture.LottoNumberFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("n개의 로또 번호 테스트")
class LottoNumbersTest {

    @Test
    @DisplayName("올바른 로또 번호 생성")
    fun `sut returns correctly`() {
        // Arrange
        val value = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(6),
        )

        // Act
        val lottoNumbers = LottoNumbers(value)

        // Assert
        assertThat(lottoNumbers.value).hasSize(6)
        assertThat(lottoNumbers.value).containsExactly(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(6),
        )
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있을 경우 예외 발생")
    fun `sut throws InvalidLottoNumberException when duplicate lotto numbers`() {
        // Arrange
        val value = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(5),
        )

        // Act, Assert
        assertThrows<InvalidLottoNumberException> { LottoNumbers(value) }
    }

    @Test
    @DisplayName("로또 번호가 없을 경우 예외 발생")
    fun `sut throws InvalidLottoNumberException when empty lotto numbers`() {
        // Arrange
        val value = emptyList<LottoNumber>()

        // Act, Assert
        assertThrows<InvalidLottoNumberException> { LottoNumbers(value) }
    }

    @Test
    @DisplayName("로또 번호에 당첨 번호가 포함될 경우 true 반환")
    fun `sut returns true when winning number contains lotto numbers`() {
        // Arrange
        val value = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(6),
        )
        val winningNumber = 4

        // Act
        val sut = LottoNumbers(value)
        val result = sut.containsWinningNumbers(winningNumber)

        // Assert
        assertThat(result).isTrue
    }

    @Test
    @DisplayName("로또 번호에 당첨 번호가 포함되어있지 않은 경우 false 반환")
    fun `sut returns false when winning number not contains lotto numbers`() {
        // Arrange
        val value = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(6),
        )
        val winningNumber = 10

        // Act
        val sut = LottoNumbers(value)
        val result = sut.containsWinningNumbers(winningNumber)

        // Assert
        assertThat(result).isFalse
    }

    // TODO: containsBonusNumber Test
    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함될 경우 true 반환")
    fun `sut returns true when bonus number contains lotto numbers`() {
        // Arrange
        val value = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(6),
        )
        val bonusNumber = 1

        // Act
        val sut = LottoNumbers(value)
        val result = sut.containsBonusNumber(bonusNumber)

        // Assert
        assertThat(result).isTrue
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있지 않은 경우 false 반환")
    fun `sut returns false when bonus number not contains lotto numbers`() {
        // Arrange
        val value = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(6),
        )
        val bonusNumber = 45

        // Act
        val sut = LottoNumbers(value)
        val result = sut.containsBonusNumber(bonusNumber)

        // Assert
        assertThat(result).isFalse
    }
}
