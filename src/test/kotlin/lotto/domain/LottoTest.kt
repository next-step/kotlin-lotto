package lotto.domain

import lotto.exception.InvalidLottoNumberException
import lotto.fixture.LottoNumberFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("로또 한개 단위 테스트")
class LottoTest {

    @Test
    @DisplayName("올바른 로또 번호 생성")
    fun `sut returns correctly`() {
        // Act
        val lottoNumbers = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(6),
        )

        // Assert
        assertThat(lottoNumbers).hasSize(6)
        assertThat(lottoNumbers).containsExactly(
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
        assertThrows<InvalidLottoNumberException> { Lotto(value) }
    }

    @Test
    @DisplayName("로또 번호가 없을 경우 예외 발생")
    fun `sut throws InvalidLottoNumberException when empty lotto numbers`() {
        // Arrange
        val value = emptyList<LottoNumber>()

        // Act, Assert
        assertThrows<InvalidLottoNumberException> { Lotto(value) }
    }

    @Test
    @DisplayName("로또 번호에 당첨 번호가 포함되어 있으면 포함된 개수를 반환한다")
    fun `sut returns match count when lotto numbers contains winning number`() {
        // Arrange
        val lottoNumbers = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(7),
        )

        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val winningNumber = WinningNumber.of(winningNumbers, 7)

        // Act
        val sut = Lotto(lottoNumbers)
        val matchCount = sut.matchWinningNumber(winningNumber)

        // Assert
        assertThat(matchCount).isEqualTo(5)
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있을 경우 true를 반환한다")
    fun `sut returns true when lotto numbers contains bonus number`() {
        // Arrange
        val lottoNumbers = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(7),
        )

        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val winningNumber = WinningNumber.of(winningNumbers, 7)

        // Act
        val sut = Lotto(lottoNumbers)
        val isBonus = sut.matchBonusNumber(winningNumber)

        // Assert
        assertThat(isBonus).isTrue
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있지 않을 경우 false를 반환한다")
    fun `sut returns false when lotto numbers not contains bonus number`() {
        // Arrange
        val lottoNumbers = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(7),
        )

        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val winningNumber = WinningNumber.of(winningNumbers, 45)

        // Act
        val sut = Lotto(lottoNumbers)
        val isBonus = sut.matchBonusNumber(winningNumber)

        // Assert
        assertThat(isBonus).isFalse
    }
}
