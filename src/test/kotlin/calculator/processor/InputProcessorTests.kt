package calculator.processor

import calculator.model.PositiveNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class InputProcessorTests {
    private lateinit var inputProcessor: InputProcessor

    @BeforeEach
    fun setUp() {
        inputProcessor = InputProcessor()
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "\t"])
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        val expected = positiveNumberList("0")
        assertThat(inputProcessor.convertStringToList(text)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "4", "1.2"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        val expected = positiveNumberList(text)
        assertThat(inputProcessor.convertStringToList(text)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3", "1,2,3", "1:2: 3"])
    fun `구분자는 기본적으로 쉼표와 콜론을 사용할 수 있다`(text: String) {
        val expected = positiveNumberList("1", "2", "3")
        assertThat(inputProcessor.convertStringToList(text)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "a", "-1,2", "a,-3", "1,"])
    fun `문자열 계산기에 음수나 다른 문자열을 전달하는 경우 RuntimeException 예외 처리를 한다`(text: String) {
        assertThrows<RuntimeException> { inputProcessor.convertStringToList(text) }
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["""//;\n1;2;3"""])
    fun customDelimiter(text: String) {
        val expected = positiveNumberList("1", "2", "3")
        assertThat(inputProcessor.convertStringToList(text)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["""//.\n1.2.3"""])
    fun `마침표는 커스텀 구분자로 사용할 수 없다`(text: String) {
        assertThrows<IllegalArgumentException> { inputProcessor.convertStringToList(text) }
    }

    private fun positiveNumberList(vararg tokens: String) =
        tokens.map { PositiveNumber(it.trim().toDouble()) }
}
