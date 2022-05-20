package calculator.processor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputProcessorTests {
    private lateinit var inputProcessor: InputProcessor

    @BeforeEach
    fun setUp() {
        inputProcessor = InputProcessor()
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "\t"])
    fun emptyOrNull(text: String?) {
        val expected = "0"
        assertThat(inputProcessor.convertStringToZeroIfNull(text)).isEqualTo(expected)
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1", "4"])
    fun oneNumber(text: String) {
        val expected = text
        assertThat(inputProcessor.convertStringToZeroIfNull(text)).isEqualTo(expected)
    }
}
