package stringcalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ToNumbersTest {
    @ParameterizedTest
    @CsvSource(value = ["1,2,3", "1,3,5", "6,1,7"])
    fun `문자열 리스트로부터 숫자 리스트를 얻을 수 있다`(string1: String, string2: String, string3: String) {
        val strings = listOf(string1, string2, string3)
        val expected = listOf(string1.toInt(), string2.toInt(), string3.toInt())
        Assertions.assertThat(toNumbers(strings)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,a,3", "1,-3,5"])
    fun `숫자 이외의 값 또는 음수가 포함된 경우 RuntimeException 에러가 발생한다`(string1: String, string2: String, string3: String) {
        val strings = listOf(string1, string2, string3)
        Assertions.assertThatThrownBy { toNumbers(strings) }.isInstanceOf(java.lang.RuntimeException::class.java)
    }
}
