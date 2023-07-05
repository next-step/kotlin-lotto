package stringaddcalculator.domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-2", "-3"])
    fun `음수를 입력할 경우 IllegalArgumentException 발생`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { Number.of(input) }
    }

    @ParameterizedTest
    @EmptySource
    fun `빈 문자열을 입력할 경우 IllegalArgumentException 발생`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { Number.of(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+"])
    fun `숫자가 아닌 문자열을 입력할 경우 IllegalArgumentException 발생`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { Number.of(input) }
    }
}
