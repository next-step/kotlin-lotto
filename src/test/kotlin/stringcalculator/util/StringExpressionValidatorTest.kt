package stringcalculator.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import stringcalculator.util.StringExpressionValidator.isOneDigitNaturalNumber

@DisplayName("문자열 계산에 필요한 유효성 검사를 담당하는 객체인 `StringExpressionValidator` 테스트")
internal class StringExpressionValidatorTest {
    @DisplayName("`null`, `빈 문자열`이 주어지면 `null`, `빈 문자열` 확인 시 `true` 반환")
    @ParameterizedTest
    @NullAndEmptySource
    fun nullOrBlankReturnTrue_IfGivenNullOrEmptyStringValue(expression: String?) {
        // Arrange
        // Act
        // Assert
        assertThat(expression.isNullOrBlank()).isTrue
    }

    @DisplayName("`비어있지 않은 문자열`이 주어지면 `null`, `빈 문자열` 확인 시 `false` 반환")
    @ParameterizedTest
    @ValueSource(strings = ["7", "1,2,3", "1;2;3", "4:5", "//;\\n1;2;3"])
    fun nullOrBlankReturnFalse_IfGivenNotBlankStringValue(expression: String?) {
        // Arrange
        // Act
        // Assert
        assertThat(expression.isNullOrBlank()).isFalse
    }

    @DisplayName("한 자리 자연수가 문자열로 주어지면 한 자리 자연수 확인 시 `true` 반환")
    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "2", "5", "8", "9"])
    fun oneDigitNaturalNumberIsTrue_IfGivenOneDigitNaturalNumber(expression: String) {
        // Arrange
        // Act
        // Assert
        assertThat(expression.isOneDigitNaturalNumber()).isTrue
    }

    @DisplayName("한 자리가 아닌 문자열이 주어지면 한 자리 자연수 확인 시 `false` 반환")
    @ParameterizedTest
    @ValueSource(strings = ["", "12", "00", "1_897", "12_389_127", "A", "Z", "*", "/", "!"])
    fun oneDigitNaturalNumberIsFalse_IfGivenNotOneDigitNaturalNumber(expression: String) {
        // Arrange
        // Act
        // Assert
        assertThat(expression.isOneDigitNaturalNumber()).isFalse
    }
}
