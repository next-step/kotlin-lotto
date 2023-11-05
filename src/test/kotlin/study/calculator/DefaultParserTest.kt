package study.calculator

import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class DefaultParserTest {
    private lateinit var parser: DefaultParser

    @BeforeEach
    fun setUp() {
        parser = DefaultParser()
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideSingleNumber")
    fun oneNumber(text: String, expected: List<Int>) {
        assertThat(parser.parse(text)).isEqualTo(expected)
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @MethodSource("provideTwoNumbers")
    fun twoNumbers(text: String, expected: List<Int>) {
        assertThat(parser.parse(text)).isEqualTo(expected)
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideStringsForColons")
    fun colons(text: String, expected: List<Int>) {
        assertThat(parser.parse(text)).isEqualTo(expected)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideStringsForCustomDelimiter")
    fun customDelimiter(text: String, expected: List<Int>) {
        assertThat(parser.parse(text)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideStringsForCustomDelimiter(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//;\n1;2;3", listOf(1, 2, 3))
            )
        }

        @JvmStatic
        fun provideStringsForColons(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1,2:3", listOf(1, 2, 3))
            )
        }

        @JvmStatic
        fun provideSingleNumber(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1", listOf(1))
            )
        }

        @JvmStatic
        fun provideTwoNumbers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1,2", listOf(1, 2))
            )
        }
    }
}
