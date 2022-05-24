package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class StringDelimiterTest {

    @ParameterizedTest
    @MethodSource("stringAndListProvider")
    fun `구분자로 숫자 문자열을 나눈다`(testString: String, expected: List<String>) {
        Assertions.assertThat(StringParser.getNumberStrings(testString)).isEqualTo(expected)
    }

    @Test
    fun `커스텀 구분자로 문자열을 나눈다`() {
        val testString = "//!\\n1;2,3!4"
        val expected = listOf("1", "2", "3", "4")

        Assertions.assertThat(StringParser.getNumberStrings(testString)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun stringAndListProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1,2", listOf("1", "2")),
                Arguments.of("1;2", listOf("1", "2")),
                Arguments.of("1;2,3", listOf("1", "2", "3")),
            )
        }
    }
}
