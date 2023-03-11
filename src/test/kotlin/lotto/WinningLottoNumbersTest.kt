package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottoNumbersTest {
    @Test
    @DisplayName("보너스 번호는 당첨번호가 될 수 없습니다.")
    fun `sut`() {
        // Arrange
        val lottoNumbers = LottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )

        // Act
        val actual = assertThrows<IllegalArgumentException> { WinningLottoNumbers(lottoNumbers, LottoNumber(5)) }

        // Assert
        assertThat(actual.message).isEqualTo("보너스 번호는 당첨번호가 될 수 없습니다")
    }
}
