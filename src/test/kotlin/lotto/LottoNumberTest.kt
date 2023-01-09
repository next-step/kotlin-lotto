package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoNumberTest {
    @Test
    @DisplayName("로또 번호가 1보다 작은경우")
    fun `sut LottoNumber set under 1`() {
        // Arrange

        // Act
        val actual = assertThrows<IllegalArgumentException> { LottoNumber(value = 0) }

        // Assert
        assertThat(actual.message).isEqualTo("로또 숫자는 1 이상이어야 합니다")
    }

    @Test
    @DisplayName("로또 번호가 45보다 큰경우")
    fun `sut LottoNumber set over 45`() {
        // Arrange

        // Act
        val actual = assertThrows<IllegalArgumentException> { LottoNumber(value = 46) }

        // Assert
        assertThat(actual.message).isEqualTo("로또 숫자는 45 이하여야 합니다")
    }
}
