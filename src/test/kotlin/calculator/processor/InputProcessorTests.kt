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
        assertThat(inputProcessor.convertStringToZeroIfNull(text)).isEqualTo("0")
    }
}
