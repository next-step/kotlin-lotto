package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculator {
    fun inputText(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        return text.split(",").sumOf { it.toInt() }
    }
}

class StringCalculatorTest {
    private lateinit var calculator: StringCalculator

    @BeforeEach
    fun init() {
        calculator = StringCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        calculator.inputText(text) shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        calculator.inputText(text) shouldBe text.toInt()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2", "2,3", "3,3"])
    fun `숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String) {
        val expected = text.split(",").sumOf { it.toInt() }
        calculator.inputText(text) shouldBe expected
    }
}
