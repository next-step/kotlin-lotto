package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class ParamsTest {

    @ParameterizedTest
    @MethodSource("generateHappyPathTestData")
    fun `getParams 해피패스 테스트`(text: String, intList: List<Int>) {
        Assertions.assertThat(Params(text).intList).isEqualTo(intList)
    }

    @ParameterizedTest
    @MethodSource("generateCustomDelimiterTestData")
    fun `getParams 커스텀구분자 테스트`(text: String, intList: List<Int>) {
        Assertions.assertThat(Params(text).intList).isEqualTo(intList)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,2,3", "4,a,6,7", "1,-1,5", "-1,6,4"])
    fun `파싱된 결과가 숫자 이외의 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(input: String) {
        assertThrows<RuntimeException> {
            Params(input)
        }
    }

    @ParameterizedTest
    @MethodSource("generateWhitespaceTestData")
    fun `공백이 입력되면 0으로 처리한다`(text: String, intList: List<Int>) {
        Assertions.assertThat(Params(text).intList).isEqualTo(intList)
    }

    @ParameterizedTest
    @MethodSource("generateEmptyTestData")
    fun `빈 문자열 입력되면 0으로 처리한다`(text: String, intList: List<Int>) {
        Assertions.assertThat(Params(text).intList).isEqualTo(intList)
    }

    @Test
    fun `null이 입력되면 0으로 처리한다`() {
        Assertions.assertThat(Params(null).intList).isEqualTo(listOf(0))
    }

    companion object {
        @JvmStatic
        fun generateHappyPathTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1:2:3", listOf(1, 2, 3)),
                Arguments.of("2,3,4", listOf(2, 3, 4)),
                Arguments.of("2,3:4", listOf(2, 3, 4)),
            )
        }

        @JvmStatic
        fun generateCustomDelimiterTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//;\n1;2;3", listOf(1, 2, 3)),
                Arguments.of("//,\n2,3,4", listOf(2, 3, 4)),
                Arguments.of("//&\n1&2&3", listOf(1, 2, 3)),
            )
        }

        @JvmStatic
        fun generateWhitespaceTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(" ", listOf(0)),
                Arguments.of("1, ,2", listOf(1, 0, 2)),
                Arguments.of(" ,1", listOf(0, 1)),
            )
        }

        @JvmStatic
        fun generateEmptyTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1,,2", listOf(1, 0, 2)),
                Arguments.of(",1", listOf(0, 1)),
                Arguments.of("1,", listOf(1, 0)),
            )
        }
    }
}
