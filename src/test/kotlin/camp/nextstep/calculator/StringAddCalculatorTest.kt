package camp.nextstep.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        assertThat(StringAddCalculator.calculate(text)).isZero
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1", "1000", "101234"])
    fun oneNumber(text: String) {
        assertThat(StringAddCalculator.calculate(text)).isEqualTo(Integer.parseInt(text))
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        delimiter = '=',
        value = [
            "1,10=11",
            "5,10=15",
            "140,10=150",
            "5,23=28",
            "15,100=115",
        ]
    )
    fun twoNumbers(exp: String, expected: Int) {
        assertThat(StringAddCalculator.calculate(exp)).isEqualTo(expected)
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        delimiter = '=',
        value = [
            "1,10:500=511",
            "5:10=15",
            "100,10:7=117",
            "100:5,23=128",
            "5:15,100=120",
        ]
    )
    fun colons(exp: String, expected: Int) {
        assertThat(StringAddCalculator.calculate(exp)).isEqualTo(expected)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        delimiterString = "=>",
        textBlock = """
        '//;${'\n'}1;2;3'      => 6 
        '//+${'\n'}1+10+500'   => 511
        '//-${'\n'}10-10-100'  => 120
        '///${'\n'}1/10'       => 11
        '//.${'\n'}1.1.1.1'    => 4"""
    )
    fun customDelimiter(exp: String, expected: Int) {
        assertThat(StringAddCalculator.calculate(exp)).isEqualTo(expected)
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    fun negative() {
        assertThrows<RuntimeException> { StringAddCalculator.calculate("-1") }
    }
}
