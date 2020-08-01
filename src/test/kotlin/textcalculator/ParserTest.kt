package textcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParserTest {
    @Test
    fun `split() 문자열을 구분자로 쪼갠다`() {
        assertThat(
            Parser().split("1:1:2,33")
        ).isEqualTo(
            listOf("1", "1", "2", "33")
        )
    }

    @Test
    fun `spliter의 초기 값은 콜론과 콤마`() {
        assertThat(
            Parser().spliter
        ).contains(":", ",").hasSize(2)
    }

    @ParameterizedTest
    @ValueSource(strings = [";", "_", "-", "a", "$"])
    fun `checkIfCustomPrefix() 프리픽스로 커스텀 구분자 있으면 spliter에 추가`(text: String) {
        val parser = Parser()
        assertThat(parser.spliter).contains(":", ",").hasSize(2)

        parser.checkIfCustomPrefix("//$text\n1:1:1")

        assertThat(parser.spliter).contains(":", ",", text).hasSize(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:1:1", "1;2:3", "1212asd"])
    fun `checkIfCustomPrefix() 프리픽스 제거하고 나머지 문자열을 반환`(text: String) {
        assertThat(
            Parser().checkIfCustomPrefix("//;\n$text")
        ).isEqualTo(text)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:1:1", "1;2:3", "1212asd"])
    fun `checkIfCustomPrefix() 해당되는 문자열 없으면 문자열 원본을 반환`(text: String) {
        assertThat(
            Parser().checkIfCustomPrefix(text)
        ).isEqualTo(text)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:1:1", "1;2:3", "//\n1212asd"])
    fun `checkIfCustomPrefix() 해당되는 문자열 없으면 구분자 추가 없음`(text: String) {
        val parser = Parser()
        parser.checkIfCustomPrefix(text)

        assertThat(parser.spliter).contains(":", ",").hasSize(2)
    }
}
