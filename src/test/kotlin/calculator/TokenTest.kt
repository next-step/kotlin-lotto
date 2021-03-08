package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

internal class TokenTest {

    @Test
    fun `토큰 생성 시 콤마(,)를 구분자로 사용한다`() {
        val input: String = "a,b,c"
        val expected = listOf("a", "b", "c")

        val result = Token(input)

        assertThat(result.values).containsExactlyElementsOf(expected)
    }

    @Test
    fun `객체 생성 시 콜론을 구분자로 사용한다`() {
        val input: String = "a:b:c"
        val expected = listOf("a", "b", "c")

        val result = Token(input)

        assertThat(result.values).containsExactlyElementsOf(expected)
    }

    @Test
    fun `객체 생성 시 콤마와 콜론을 함께 구분자로 사용할 수 있다`() {
        val input: String = "a,b:c"
        val expected = listOf("a", "b", "c")

        val result = Token(input)

        assertThat(result.values).containsExactlyElementsOf(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "\n"])
    fun `공백으로 객체를 생성하는 경우 예외를 반환한다`(input: String) {
        val expectedMessage = "문자열은 공백일 수 없습니다. input: $input"
        val result = assertThrows<IllegalArgumentException> { Token(input) }
        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @ParameterizedTest(name = "{0} 은 {1} 로 쪼개진다")
    @MethodSource("generateCustomDelimiterData")
    fun `문자열 입력 시 커스텀 규칙에 따라 구분자를 지정할 수 있다`(input: String, expected: List<String>) {
        val result = Token(input)
        assertThat(result.values).containsExactlyElementsOf(expected)
    }

    @ParameterizedTest(name = "{0} 은 {1} 로 쪼개진다")
    @MethodSource("generateTwoOverCustomDelimiterData")
    fun `커스텀 구분자를 두글자 이상으로 지정할 경우 사용할 수 없으며, 구분자는 콤마와 콜론이 된다`(input: String, expected: List<String>) {
        val result = Token(input)
        assertThat(result.values).containsExactlyElementsOf(expected)
    }

    @ParameterizedTest(name = "{0} 은 {1} 로 쪼개진다")
    @MethodSource("generateTwoOverCustomDelimiterData")
    fun `커스텀 구분자를 두글자 이상으로 지정할 경우 구분자는 콤마와 콜론을 사용한다`(input: String, expected: List<String>) {
        val result = Token(input)
        assertThat(result.values).containsExactlyElementsOf(expected)
    }

    @ParameterizedTest(name = "{0} 은 {1} 로 쪼개진다")
    @MethodSource("generateOnlyDelimiterData")
    fun `구분자 사이에 문자가 존재하지 않는 경우 해당 토큰은 비어있을 수 있다`(input: String, expected: List<String>) {
        val result = Token(input)
        assertThat(result.values).containsExactlyElementsOf(expected)
    }

    companion object {
        @JvmStatic
        fun generateCustomDelimiterData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//+\na+b+c", listOf("a", "b", "c")),
                Arguments.of("//-\n1-2-3", listOf("1", "2", "3")),
                Arguments.of("//5\n1234567", listOf("1234", "67"))
            )
        }

        @JvmStatic
        fun generateTwoOverCustomDelimiterData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//++\na++b", listOf("//++\na++b")),
                Arguments.of("//-$\n1-$2-,3", listOf("//-$\n1-$2-", "3")),
                Arguments.of("//&&&#\n12:3,4:567", listOf("//&&&#\n12", "3", "4", "567"))
            )
        }

        @JvmStatic
        fun generateOnlyDelimiterData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(",:", listOf("", "", "")),
                Arguments.of("//+\na++b", listOf("a", "", "b")),
                Arguments.of("//-\n--", listOf("", "", ""))
            )
        }
    }
}
