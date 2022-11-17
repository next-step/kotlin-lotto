package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringNumbersTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null을 입력할 경우 0이 담긴 리스트를 반환한다`(text: String?) {
        assertThat(StringNumbers(text).list).isEqualTo(listOf(0))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "3", "10"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자가 담긴 리스트를 반환한다`(text: String) {
        assertThat(StringNumbers(text).list).isEqualTo(listOf(text.toInt()))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,3", "3,1,4"])
    fun `쉼표를 구분자를 가지는 문자열을 분리하여 리스트로 반환한다`(text: String) {
        assertThat(StringNumbers(text).list).isEqualTo(text.split(",").map { it.toInt() })
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:3", "3:1:4"])
    fun `콜론을 구분자를 가지는 문자열을 분리하여 리스트로 반환한다`(text: String) {
        assertThat(StringNumbers(text).list).isEqualTo(text.split(":").map { it.toInt() })
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "a:1", "23:$"])
    fun `숫자 이외의 값을 전달하는 경우 예외가 발생한다`(text: String) {
        assertThrows<java.lang.RuntimeException> { StringNumbers(text) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-1:1", "23:-3"])
    fun `음수의 값을 전달하는 경우 예외가 발생한다`(text: String) {
        assertThrows<java.lang.RuntimeException> { StringNumbers(text) }
    }

    @ParameterizedTest
    @CsvSource(value = ["'//;\n1;2;3', 1:2:3", "'//#\n2#4#5', 2:4:5"])
    @DisplayName("'//'와 '\n' 사이에 위치하는 문자를 커스텀 구분자로 분리하여 리스트로 반환한다")
    fun `커스텀 구분자를 사용한다`(text: String, numbersText: String) {
        assertThat(StringNumbers(text).list).isEqualTo(numbersText.split(":").map { it.toInt() })
    }
}
