package util

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class SeparatorTest {

    @Test
    fun `커스텀 구분자를 등록하고 이를 통해 구분할 수 있다`() {
        val input = "//;\n1;2;3;4;2;231"
        Separator.extractIntegers(input) shouldBe listOf(1, 2, 3, 4, 2, 231)
    }

    @Test
    fun `null 이 입력될 경우 0이 반환된다`() {
        Separator.extractIntegers(null) shouldBe listOf(0)
    }

    @ValueSource(strings = ["1,33.2", "일,이,삼", "-1,-2,-3", "0, 1,!2", "01,  -2"])
    @ParameterizedTest
    fun `문자열에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 던진다`(
        input: String,
    ) {
        shouldThrow<IllegalArgumentException> {
            Separator.extractIntegers(input)
        }
    }
}
