package calculator.domain

import calculator.exception.InvalidExpressionException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class NumberTest {

    @ParameterizedTest
    @CsvSource(value = ["-1", "d,3"])
    @DisplayName("식에 음수 및 숫자 외의 값을 입력할 경우")
    fun `sut throw InvalidExpressionException when negative or invalid number`(input: String) {
        // Act, Assert
        Assertions.assertThatExceptionOfType(InvalidExpressionException::class.java)
            .isThrownBy { Number(input) }
    }
}
