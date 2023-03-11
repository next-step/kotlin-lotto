package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoAutoGeneratorTest {
    @Test
    @DisplayName("로또를 입력받은 세트 만큼 생성해주고 이 로또는 중복되지 않은 1~45의 6개 숫자다")
    fun `sut auto generate lotto`() {
        // Arrange
        val sut = LottoAutoGenerator()

        // Act
        val actual = sut.generate(3)

        // Assert
        assertThat(actual.size).isEqualTo(3)
        assertThat(actual.first().value.size).isEqualTo(6)
        assertThat(actual.first().value.distinct().size).isEqualTo(6)
        actual.first().value.forEach { lotto ->
            assertThat(1..45).contains(lotto.value)
        }
    }
}
