package calculator.domain

import calculator.exception.InvalidExpressionException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null이 입력될 경우 0을 반환한다")
    fun `sut returns zero when expression is null or empty`(input: String?) {
        // Arrange
        val sut = Expression(input)

        // Act
        val numbers = sut.prepareCalculation()

        // Assert
        assertThat(numbers).hasSize(1)
        assertThat(numbers).containsExactly(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1"])
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    fun `sut returns one when input is one`(input: String) {
        // Arrange
        val sut = Expression(input)

        // Act
        val numbers = sut.prepareCalculation()

        // Assert
        assertThat(numbers).hasSize(1)
        assertThat(numbers).containsExactly(1)
    }

    @Test
    @DisplayName("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자를 분리한다")
    fun `sut returns segregated expressions when delimiter is (,)`() {
        // Assert
        val sut = Expression("1,2")

        // Act
        val numbers = sut.prepareCalculation()

        // Assert
        assertThat(numbers).hasSize(2)
        assertThat(numbers).contains(1, 2)
    }

    @Test
    @DisplayName("구분자를 쉼표(,) 이외에 콜론(:)을 사용하여 분리할 수 있다")
    fun `sut returns segregated expressions when delimiter is colon`() {
        // Assert
        val sut = Expression("1,2:3")

        // Act
        val numbers = sut.prepareCalculation()

        // Assert
        assertThat(numbers).hasSize(3)
        assertThat(numbers).contains(1, 2, 3)
    }

    @ParameterizedTest
    @CsvSource(value = ["-1", "d,3"])
    @DisplayName("식에 음수 및 숫자 외의 값을 입력할 경우")
    fun `sut throw InvalidExpressionException when negative or invalid number`(input: String) {
        // Assert
        val sut = Expression(input)

        // Act, Assert
        assertThatExceptionOfType(InvalidExpressionException::class.java)
            .isThrownBy { sut.prepareCalculation() }
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    fun `sut returns segregated expressions when custom delimiter`(input: String) {
        // Assert
        val sut = Expression(input)

        // Act
        val numbers = sut.prepareCalculation()

        // Assert
        assertThat(numbers).hasSize(3)
        assertThat(numbers).contains(1, 2, 3)
    }
}
