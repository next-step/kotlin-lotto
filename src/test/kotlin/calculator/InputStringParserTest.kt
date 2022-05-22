package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class InputStringParserTest() {

    @ParameterizedTest
    @CsvSource(value = ["1,2:3[1,2,3", "4,5:7[4,5,7", "1,5:2[1,5,2"], delimiter = '[')
    fun `문자열 숫자 파싱 테스트`(input: String, result: String) {
        val seperatedValue = InputStringParser(input).getSeperatedValue()
        assertThat(seperatedValue).isEqualTo(result.split(",").map { it.toInt() })
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:-3", "4:-5:1"])
    fun `문자열 숫자 파싱 오류 테스트`(input: String) {
        assertThrows<RuntimeException> { InputStringParser(input).getSeperatedValue() }
    }
}
