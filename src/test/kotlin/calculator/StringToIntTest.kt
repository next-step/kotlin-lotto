package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class StringToIntTest {

    @ParameterizedTest
    @ValueSource(strings = ["5", "4", "232", "44", "0", "504"])
    fun `입력받은 문자가 양수면 숫자로 처리한다`(input: String) {
        val result = parseToInt(input)
        assertThat(result).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "\t"])
    @NullSource
    fun `null, 공백을 입력 받으면 0으로 반환한다`(input: String?) {
        val result = parseToInt(input)

        assertThat(result).isEqualTo(0)
    }
}
