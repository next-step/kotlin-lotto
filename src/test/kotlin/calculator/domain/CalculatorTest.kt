package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource("1,2:3$6", "3:6,10$19", delimiter = '$')
    @DisplayName("입력받은 식의 합을 반환한다")
    fun `sut returns correctly`(input: String, expected: String) {
        // Arrange
        val sut = Calculator(input)

        // Act
        val result = sut.add()

        // Assert
        assertThat(result).isEqualTo(expected.toInt())
    }

    @Test
    @DisplayName("커스텀 구분자를 지정한 식의 합을 반환한다")
    fun `sut returns segregated expressions when custom delimiter`() {
        // Assert
        val sut = Calculator("//@\n1@2@3")

        // Act
        val result = sut.add()

        // Assert
        assertThat(result).isEqualTo(6)
    }
}
