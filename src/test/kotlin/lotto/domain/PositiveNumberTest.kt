package lotto.domain

import calculator.PositiveNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 100])
    fun `자연수로 객체 생성할 수 있다`(input: Int) {
        val positiveNumber = PositiveNumber(input)
        val result = positiveNumber.value
        assertThat(result).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(ints = [-100, -1, 0])
    fun `음수나 0인 숫자로 객체를 생성하는 경우 예외를 반환한다`(input: Int) {
        val expectedMessage: String = "양수만 허용합니다. value: $input"
        val result: IllegalArgumentException = assertThrows { PositiveNumber(input) }
        assertThat(result.message).isEqualTo(expectedMessage)
    }
}
