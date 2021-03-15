package caculator.ui

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class InputTest {

    @ParameterizedTest
    @MethodSource("defaultDelimiterInputProvider")
    fun `기본 구분자 기준으로 숫자들을 파싱한다`(inputString: String, parsedInput: List<Int>) {
        assertThat(Input(inputString).numbers).containsExactlyInAnyOrderElementsOf(parsedInput)
    }

    @ParameterizedTest
    @MethodSource("customDelimiterInputProvider")
    fun `커스텀 구분자로 숫자들을 파싱한다`(inputString: String, parsedInput: List<Int>) {
        assertThat(Input(inputString).numbers).containsAll(parsedInput)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-100:100", "-50;-100:0"])
    fun `숫자로 음수를 입력하면 예외 발생`(inputString: String) {
        Assertions.assertThatThrownBy {
            Input(inputString)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {
        @JvmStatic
        fun defaultDelimiterInputProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "1,2,3",
                    listOf(1, 2, 3)
                ),
                Arguments.of(
                    "100:50:1",
                    listOf(100, 50, 1)
                ),
                Arguments.of(
                    "5002:1,100",
                    listOf(5002, 1, 100)
                )
            )
        }

        @JvmStatic
        fun customDelimiterInputProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "//;\n1;2;3",
                    listOf(1, 2, 3)
                ),
                Arguments.of(
                    "//@\n20@5@7",
                    listOf(20, 5, 7)
                ),
                Arguments.of(
                    "//ㅁ\n17ㅁ500ㅁ1",
                    listOf(17, 500, 1)
                )
            )
        }
    }
}
