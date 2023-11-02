package stringcalculator

import io.kotest.assertions.Expected
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import stringaddcalculator.StringAddCalculator

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        calculator.add(text) shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        calculator.add(text) shouldBe Integer.parseInt(text)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2#3", "3,5#8", "12,5#17"], delimiter = '#')
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String, expected: Int) {
        calculator.add(text) shouldBe expected
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2:3#6", "1,2:5#8", "3:6:9#18"], delimiter = '#')
    fun `구분자를 쉼표(,) 이외에 콜론을 사용할 수 있다`(text:String, expected: Int) {
        calculator.add(text) shouldBe expected
    }
}
