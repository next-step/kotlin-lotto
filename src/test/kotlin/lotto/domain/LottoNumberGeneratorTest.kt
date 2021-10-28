package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 번호 생성기 테스트")
class LottoNumberGeneratorTest {

    @Test
    @DisplayName("6개의 로또 번호를 생성할 수 있다")
    fun `sut returns correctly`() {
        // Arrange
        val sut = LottoNumberGenerator

        // Act
        val lottoNumbers: List<Int> = sut.generate()

        // Assert
        assertThat(lottoNumbers).hasSize(6)
    }

    @Test
    @DisplayName("로또 번호는 1 ~ 45의 번호로 이루어져 있다")
    fun `sut returns lotto number size is 45`() {
        // Arrange
        val sut = LottoNumberGenerator

        // Act
        val lottoNumbers: List<Int> = sut.generate()

        // Assert
        assertThat(lottoNumbers.first()).isGreaterThanOrEqualTo(1)
        assertThat(lottoNumbers.last()).isLessThanOrEqualTo(45)
    }
}
