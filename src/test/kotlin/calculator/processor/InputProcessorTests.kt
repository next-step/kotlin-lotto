package calculator.processor

import calculator.model.PositiveNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
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
        val expected = positiveNumberList("0")
        assertThat(inputProcessor.convertStringToList(text)).isEqualTo(expected)
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1", "4", "1.2"])
    fun oneNumber(text: String) {
        val expected = positiveNumberList(text)
        assertThat(inputProcessor.convertStringToList(text)).isEqualTo(expected)
    }

    @DisplayName(value = "구분자는 기본적으로 쉼표(,)와 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3", "1,2,3", "1:2: 3"])
    fun splitByDefaultDelimiter(text: String) {
        val expected = positiveNumberList("1", "2", "3")
        assertThat(inputProcessor.convertStringToList(text)).isEqualTo(expected)
    }

    @DisplayName(value = "문자열 계산기에 음수나 다른 문자열을 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["-1", "a", "-1,2", "a,-3"])
    fun notPositiveNumber(text: String) {
        assertThrows<RuntimeException> { inputProcessor.convertStringToList(text) }
    }

    private fun positiveNumberList(vararg tokens: String) =
        tokens.map { PositiveNumber(it) }
}
