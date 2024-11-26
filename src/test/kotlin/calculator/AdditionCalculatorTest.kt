package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class AdditionCalculatorTest {
    @Test
    fun `문자열의 덧셈 결과를 얻을 수 있다`() {
        val tokens = TextTokens()
        tokens.addToken("1")
        tokens.addToken("5")
        tokens.addToken("4")
        val result = tokens.sum()
        result shouldBe 10
    }
}
