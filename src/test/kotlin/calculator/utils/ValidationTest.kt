package calculator.utils

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ValidationTest {

    @Test
    @DisplayName("입력된 값이 숫자가 아닌 경우 false")
    fun `RuntimeException error when character input contains non-numeric values`() {
        val isNumeric = Validation.isNumeric("a")
        Assertions.assertThat(isNumeric).isFalse
    }

    @Test
    @DisplayName("입력된 값이 음수인 경우 true")
    fun `True if the entered value is negative`() {
        val isNegativeNumber = Validation.isNegativeNumber("-1")
        Assertions.assertThat(isNegativeNumber).isTrue
    }

    @Test
    @DisplayName("입력된 값이 양수인 경우 false")
    fun `False if the entered value is positive`() {
        val isNegativeNumber = Validation.isNegativeNumber("13")
        Assertions.assertThat(isNegativeNumber).isFalse
    }
}
