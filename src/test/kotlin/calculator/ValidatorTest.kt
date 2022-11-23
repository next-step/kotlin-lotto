package calculator

import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ValidatorTest {

    @DisplayName(value = "숫자 이외의 값을 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["a", "-1"])
    fun validate(text: String) {
        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            Validator.validate(text)
        }
    }
}
