package lotto

import lotto.domain.Lotto.Companion.NUMBER_NUM
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringHandlerTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4, 5,6", "1, 2, 3, 4, 5, 6", "1,2,3,4,5,6,"])
    fun `당첨 번호 문자열을 6개의 숫자로 변환한다`(input: String) {
        assertThat(tokenizeWinningNumbers(input).size)
            .isEqualTo(NUMBER_NUM)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,1", "10,10"])
    fun `입력받은 문자를 정수로 변환한다`(input: String, expected: Int) {
        assertThat(inputToInt(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1e10", "10,000", "1000$"])
    fun `숫자로만 이루어진 문자열이 아닐시 예외를 던진다`(input: String) {
        assertThatThrownBy { inputToInt(input) }
            .isInstanceOf(NumberFormatException::class.java)
            .hasMessage("입력은 숫자로만 구성되어야 합니다.")
    }
}
