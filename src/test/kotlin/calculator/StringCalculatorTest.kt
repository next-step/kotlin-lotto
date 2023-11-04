package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StringCalculator {
    fun inputText(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        return 1
    }
}

class StringCalculatorTest {
    private lateinit var calculator: StringCalculator

    @BeforeEach
    fun init() {
        calculator = StringCalculator()
    }

    @Test
    fun `문자열 계산기에 빈 문자열을 입력할 경우 0을 반환한다`() {
        calculator.inputText("") shouldBe 0
    }

    @Test
    fun `문자열 계산기에 null을 입력할 경우 0을 반환한다`() {
        calculator.inputText(null) shouldBe 0
    }
}
