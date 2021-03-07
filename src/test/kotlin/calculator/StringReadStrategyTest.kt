package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class StringReadStrategyTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4", "1,2,3:4", "1:2:3:4"])
    fun `기본 구분자로 문자열을 읽을때`(string: String) {
        assertThat(string.split(",", ":")).isEqualTo(listOf("1", "2", "3", "4"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3;4", "//!\n1!2!3!4", "//#\n1#2#3#4"])
    fun `커스텀 구분자로 문자열을 읽을때`(string: String) {
        val regexResult = Regex("//(.)\n(.*)").find(string)
        var separator = ""
        var pureString = ""
        regexResult?.let {
            separator = regexResult.groupValues[1]
            pureString = regexResult.groupValues[2]
        }
        assertThat(pureString.split(separator)).isEqualTo(listOf("1", "2", "3", "4"))
    }

    @ParameterizedTest
    @MethodSource("provideCustomSeparatorString")
    fun `커스텀 구분자 문자열에서 구분자만 분리할때`(string: String, resultSeparator: String) {
        val regexResult = Regex("//(.)\n(.*)").find(string)
        val separator = regexResult!!.groupValues[1]

        assertThat(separator).isEqualTo(resultSeparator)
    }

    companion object {
        @JvmStatic
        private fun provideCustomSeparatorString(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//;\n1;2;3;4", ";"),
                Arguments.of("//!\n1!2!3!4", "!"),
                Arguments.of("//#\n1#2#3#4#6", "#")
            )
        }
    }
}
