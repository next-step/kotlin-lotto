package domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class CalculatorTest {

    @Test
    fun `숫자 열이 전달되면 합을 리턴한다`() {
        val calculator = Calculator()
        val input = listOf(1, 2, 3, 4, 5)
        calculator.sumList(input) shouldBe 15
    }
}
