package lotto.domain

import lotto.exception.InvalidLottoNumberException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("로또 번호 테스트")
class LottoNumbersTest {

    @Test
    @DisplayName("올바른 로또 번호 생성")
    fun `sut returns correctly`() {
        // Arrange
        val value = listOf(
            LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6),
        )

        // Act
        val lottoNumbers = LottoNumbers(value)

        // Assert
        assertThat(lottoNumbers.value).hasSize(6)
        assertThat(lottoNumbers.value).containsExactly(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있을 경우 예외 발생")
    fun `sut throws InvalidLottoNumberException when duplicate lotto numbers`() {
        // Arrange
        val value = listOf(
            LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(5),
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
}
