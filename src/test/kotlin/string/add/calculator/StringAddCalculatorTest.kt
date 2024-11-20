package string.add.calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringAddCalculator {
    fun calculate(text: String?): Int = 0
}

@Suppress("NonAsciiCharacters")
class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 을 입력할 경우 0을 반환해야 한다`(text: String?) {
        val sum = StringAddCalculator().calculate(text)
        sum shouldBe 0
    }
}
