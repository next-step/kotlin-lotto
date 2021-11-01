package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class ParserTest {

    private val parser = Parser

    @ParameterizedTest
    @ValueSource(strings = ["0", "1"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        // when
        val result = parser.parse(text)

        // then
        assertThat(result).isEqualTo(listOf(PositiveInt(text)))
    }

    @Test
    fun `숫자 두개를 쉼표 구분자로 입력할 경우 두 숫자를 반환한다`() {
        // given
        val text = "1,2"

        // when
        val result = parser.parse(text)

        // then
        assertThat(result).isEqualTo(listOf(PositiveInt(1), PositiveInt(2)))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3", "1:2,3", "1:2:3"])
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`(text: String) {
        // when
        val result = parser.parse(text)

        // then
        assertThat(result).isEqualTo(listOf(PositiveInt(1), PositiveInt(2), PositiveInt(3)))
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//;\n1,2;3", "//;\n1;2:3"])
    fun `두개의 슬래시문자와 개행문자 사이에 커스텀 구분자를 지정할 수 있다`(text: String) {
        // when
        val result = parser.parse(text)

        // then
        assertThat(result).isEqualTo(listOf(PositiveInt(1), PositiveInt(2), PositiveInt(3)))
    }

    @Test
    fun `Parser에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { parser.parse("-1") }
    }
}
