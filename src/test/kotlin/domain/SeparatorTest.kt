package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class SeparatorTest {

    @MethodSource("testData")
    @ParameterizedTest
    fun `문자열이 입력되면 특정 구분자를 통해 숫자들을 반환한다`(
        input: String,
        expected: List<Int>,
    ) {
        val separator = Separator()
        val result = separator.extractIntegers(input)

        result shouldBe expected
    }

    @Test
    fun `특정 위치의 문자열을 커스텀 구분자로 등록할 수 있다`() {
        val separator = Separator()
        val input = "//;\n1:2,3;4;2,231"
        separator.extractIntegers(input) shouldBe listOf(1, 2, 3, 4, 2, 231)
    }

    @ValueSource(strings = ["1,33.2", "일,이,삼", "-1,-2,-3", "0, 01, +2"])
    @ParameterizedTest
    fun `문자열에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 던진다`(
        input: String,
    ) {
        val separator = Separator()
        shouldThrow<IllegalArgumentException> {
            separator.extractIntegers(input)
        }
    }

    companion object {
        @JvmStatic
        fun testData(): List<Arguments> {
            return listOf(
                Arguments.of("1,2,3", listOf(1, 2, 3)),
                Arguments.of("100,2,3", listOf(100, 2, 3)),

                Arguments.of("1:2:3", listOf(1, 2, 3)),
                Arguments.of("100:2:3", listOf(100, 2, 3)),

                Arguments.of("10,2:145", listOf(10, 2, 145)),
                Arguments.of("8:3,7", listOf(8, 3, 7)),

                Arguments.of("", listOf(0)),
            )
        }
    }
}
