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
        val lottoNumberOne = LottoNumber(1)
        val lottoNumberTwo = LottoNumber(2)
        val lottoNumberThree = LottoNumber(3)
        val lottoNumberFour = LottoNumber(4)
        val lottoNumberFive = LottoNumber(5)
        val lottoNumberSix = LottoNumber(6)
        val lottoNumberSeven = LottoNumber(7)

        val winningNumbers = listOf(
            lottoNumberOne, lottoNumberTwo, lottoNumberThree, lottoNumberFour, lottoNumberFive, lottoNumberSix,
        )
        val numbers = listOf(
            lottoNumberOne, lottoNumberTwo, lottoNumberThree, lottoNumberFour, lottoNumberFive, lottoNumberSeven
        )
        val lottoNumbers = LottoNumbers(numbers)

        // Act
        val sut = Lotto(lottoNumbers)
        val matchCount = sut.matchWinningNumber(winningNumbers)

        // Assert
        assertThat(matchCount).isEqualTo(5)
    }
}
