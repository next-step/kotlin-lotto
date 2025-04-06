import calculator.StringAddCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @DisplayName("Returns 0 when the input is null or empty")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        assertThat(calculator.add(text)).isZero()
    }

    @DisplayName("Returns the number when a single number is provided")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun oneNumber(text: String) {
        assertThat(calculator.add(text)).isEqualTo(text.toInt())
    }

    @DisplayName("Returns the sum of two numbers separated by a comma")
    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun twoNumbers(text: String) {
        assertThat(calculator.add(text)).isEqualTo(3)
    }

    @DisplayName("Allows colon (:) as an additional delimiter")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun colons(text: String) {
        assertThat(calculator.add(text)).isEqualTo(6)
    }

    @DisplayName("Supports custom delimiters between '//' and '\\n'")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        assertThat(calculator.add(text)).isEqualTo(6)
    }

    @DisplayName("Throws RuntimeException for negative numbers")
    @Test
    fun negative() {
        assertThrows<IllegalArgumentException> { calculator.add("-1") }
    }
}
