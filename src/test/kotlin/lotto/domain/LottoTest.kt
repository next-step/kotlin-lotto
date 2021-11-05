package lotto.domain

import lotto.fixture.LottoNumberFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 한개 단위 테스트")
class LottoTest {

    @Test
    @DisplayName("로또 번호에 당첨 번호가 포함되어 있으면 포함된 개수를 반환한다")
    fun `sut returns match count when lotto numbers contains winning number`() {
        // Arrange
        val winningNumbers = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(6),
        )
        val numbers = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(7),
        )
        val lottoNumbers = LottoNumbers(numbers)

        // Act
        val sut = Lotto(lottoNumbers)
        val matchCount = sut.matchWinningNumber(LottoNumbers(winningNumbers))

        // Assert
        assertThat(matchCount).isEqualTo(5)
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있을 경우 true를 반환한다")
    fun `sut returns true when lotto numbers contains bonus number`() {
        // Arrange
        val numbers = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(7),
        )
        val lottoNumbers = LottoNumbers(numbers)

        // Act
        val sut = Lotto(lottoNumbers)
        val isBonus = sut.matchBonusNumber(7)

        // Assert
        assertThat(isBonus).isTrue
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있지 않을 경우 false를 반환한다")
    fun `sut returns false when lotto numbers not contains bonus number`() {
        // Arrange
        val numbers = listOf(
            LottoNumberFixture.create(1),
            LottoNumberFixture.create(2),
            LottoNumberFixture.create(3),
            LottoNumberFixture.create(4),
            LottoNumberFixture.create(5),
            LottoNumberFixture.create(7),
        )
        val lottoNumbers = LottoNumbers(numbers)

        // Act
        val sut = Lotto(lottoNumbers)
        val isBonus = sut.matchBonusNumber(45)

        // Assert
        assertThat(isBonus).isFalse
    }
}
