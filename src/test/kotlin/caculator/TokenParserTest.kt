package caculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class TokenParserTest {

    companion object {
        @JvmStatic
        fun customParserSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("//ab\n1ab2ab3", Numbers(listOf(Number(1), Number(2), Number(3)))),
                Arguments.arguments("//1\n111111", Numbers(listOf()))
            )
        }
    }

    @DisplayName("숫자를 ',' ':' 구분한다`")
    @Test
    fun parseToken() {
        val tokenParser = TokenParser()
        val result = tokenParser.parseToken("1,2:3")

        assertThat(result).isEqualTo(Numbers(listOf(Number(1), Number(2), Number(3))))
    }

    @MethodSource("customParserSource")
    @ParameterizedTest
    fun customParser(input: String, expect: Numbers) {
        val tokenParser = TokenParser()
        val result = tokenParser.parseToken(input)

        assertThat(result).isEqualTo(expect)
    }
}
