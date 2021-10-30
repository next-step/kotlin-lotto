package calculator

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberTest {
    @ParameterizedTest
    @ValueSource(strings = ["-1", "-2"])
    fun `음수를 전달할 경우 RuntimeException 예외가 발생해야 한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { Number.make(input) }
            .withMessage("음수는 불가능합니다.")
    }
}
