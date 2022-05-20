package calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParamsTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "4,5,6,7"])
    fun `파싱된 결과가 양수 숫자라면 예외가 발생하면 안된다`(input: String) {
        Assertions.assertThat(Params(input.split(",")).values)
            .isEqualTo(input.split(",").map { it.toInt() })
    }

    @ParameterizedTest
    @ValueSource(strings = [",2,3", "4,,6,7", "1,-1,5", "-1,6,4"])
    fun `파싱된 결과가 숫자 이외의 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(input: String) {
        assertThrows<RuntimeException> {
            Params(input.split(","))
        }
    }
}
