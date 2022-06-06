package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.RuntimeException

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ["", " ", "\n", "\t"])
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환한다`(inputStr: String?) {
        val sut = StringAddCalculator()
        val actual = sut.calculate(inputStr)
        assertEquals(0, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["1|1", "2|2"], delimiter = '|')
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(inputStr: String, expected: Long) {
        val sut = StringAddCalculator()
        val actual = sut.calculate(inputStr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2|3", "1,2,3|6"], delimiter = '|') // todo "1," -> error
    fun `숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(inputStr: String, expected: Long) {
        val sut = StringAddCalculator()
        val actual = sut.calculate(inputStr)
        assertEquals(expected, actual)
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = ["1,2:3|6"], delimiter = '|')
    fun `DefaultDelimiter`(inputStr: String, expected: Long) {
        val sut = StringAddCalculator()
        val actual = sut.calculate(inputStr)
        assertEquals(expected, actual)
    }

    @DisplayName("//와 ₩n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @ParameterizedTest
    @CsvSource(value = ["//;\\n1;2;3|6", "//a\\n1a1a1|3", "//-\\n1-1-1|3"], delimiter = '|')
    fun customDelimiter(inputStr: String, expected: Long) {
        val sut = StringAddCalculator()
        val actual = sut.calculate(inputStr.replace("\\n", "\n"))
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-1,2,3", "1,-2,3"])
    fun `음수를 전달하는 경우 RuntimeException 예외가 발생해야 한다`(inputStr: String) {
        assertThrows<RuntimeException> {
            StringAddCalculator().calculate(inputStr)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,2", "2,#"])
    fun `숫자 이외의 값을 전달하는 경우 RuntimeException 예외가 발생해야 한다`(inputStr: String) {
        assertThrows<RuntimeException> {
            StringAddCalculator().calculate(inputStr)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,", "1,,2", "1$,2,3", "//;\n1;2;"])
    fun `올바르지 않은 연산식이면 RuntimeException 예외가 발생해야 한다`(inputStr: String) {
        assertThrows<RuntimeException> {
            StringAddCalculator().calculate(inputStr)
        }
    }
}
