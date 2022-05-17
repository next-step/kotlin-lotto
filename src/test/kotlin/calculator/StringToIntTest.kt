package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringToIntTest {

    @ParameterizedTest
    @ValueSource(strings = ["5", "4", "232", "44", "0", "504"])
    fun `입력받은 문자가 양수면 숫자로 처리한다`(input: String) {
        val result = parseToInt(input)
        Assertions.assertThat(result).isEqualTo(input.toInt())
    }
}
