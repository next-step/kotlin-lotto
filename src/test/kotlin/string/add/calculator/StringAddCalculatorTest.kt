package string.add.calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculator {
    fun calculate(text: String?): Int = if (text.isNullOrBlank()) 0 else text.toInt()
}

@Suppress("NonAsciiCharacters")
class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 을 입력할 경우 0을 반환해야 한다`(text: String?) {
        val sum = StringAddCalculator().calculate(text)
        sum shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "42"])
    fun `숫자 하나를 입력한 경우 해당 숫자를 반환한다`(text: String) {
        val sum = StringAddCalculator().calculate(text)
        sum shouldBe text.toInt()
    }
}
