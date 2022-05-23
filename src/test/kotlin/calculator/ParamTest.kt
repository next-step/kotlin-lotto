package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParamTest {

    @ParameterizedTest
    @ValueSource(strings = ["1", "8851", "55", "66"])
    fun `Param 생성자 해피패스 테스트`(text: String) {
        Assertions.assertThat(Param(text).value).isEqualTo(text.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "a", "-100"])
    fun `숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(text: String) {
        assertThrows<RuntimeException> {
            Param(text)
        }
    }
}
