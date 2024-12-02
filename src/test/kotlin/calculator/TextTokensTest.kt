package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class TextTokensTest {
    @Test
    fun `문자열의 덧셈 결과를 얻을 수 있다`() {
        val numbers =
            listOf(
                PositiveNumber(1),
                PositiveNumber(5),
                PositiveNumber(4),
            )
        val textTokens = TextTokens(numbers)
        val result = textTokens.sum()
        result shouldBe 10
    }
}
