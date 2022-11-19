package calculator.utils

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ValidationTest {

    @Test
    @DisplayName("입력된 값이 숫자가 아닌 경우 false")
    fun `False if character the entered value non-numeric values`() {
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

    @Test
    @DisplayName("입력된 값 중 숫자 이외의 값이 포함된 경우 RuntimeException 오류")
    fun `RuntimeException error when the entered value contains non-numeric values`() {
        assertThrows<RuntimeException> { Validation.isNumericAndNegativeNumber(listOf("a", "2")) }
    }

    @Test
    @DisplayName("입력된 값 중 음수 값이 포함된 경우 RuntimeException 오류")
    fun `RuntimeException error when the entered value contains negative values`() {
        assertThrows<RuntimeException> { Validation.isNumericAndNegativeNumber(listOf("-3", "2")) }
    }
}
