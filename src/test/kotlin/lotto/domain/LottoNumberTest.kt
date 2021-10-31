package lotto.domain

import lotto.exception.InvalidLottoNumberException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("로또 번호 테스트")
class LottoNumberTest {

    @Test
    @DisplayName("올바른 로또 번호 생성")
    fun `sut returns correctly`() {
        // Arrange
        val value = listOf(1, 2, 3, 4, 5, 6)

        // Act
        val lottoNumber = LottoNumber(value)

        // Assert
        assertThat(lottoNumber.value).hasSize(6)
        assertThat(lottoNumber.value).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있을 경우 예외 발생")
    fun `sut throws InvalidLottoNumberException when duplicate lotto numbers`() {
        // Arrange
        val value = listOf(1, 2, 3, 4, 5, 5)

        // Act, Assert
        assertThrows<InvalidLottoNumberException> { LottoNumber(value) }
    }

    @Test
    @DisplayName("로또 번호가 없을 경우 예외 발생")
    fun `sut throws InvalidLottoNumberException when empty lotto numbers`() {
        // Arrange
        val value = emptyList<Int>()

        // Act, Assert
        assertThrows<InvalidLottoNumberException> { LottoNumber(value) }
    }
}
