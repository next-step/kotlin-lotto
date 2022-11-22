package calculator.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositiveOperandTest {
    @DisplayName("음수 피연산자에 대한 예외처리 테스트")
    @Test
    fun `음수 피연산자에 대한 예외처리 테스트`() {
        assertThatThrownBy { PositiveOperand(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("음수는 입력할 수 없습니다.")
    }

    @DisplayName("입력된 값이 숫자인지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["-1", "", " ", "a", "1a", "a1", "1 1", " 1", "1 "])
    fun `입력된 값이 숫자인지 확인하는 테스트`(input: String) {
        assertThatThrownBy { PositiveOperand(input) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessageContaining("숫자 이외의 값 또는 음수는 입력할 수 없습니다.")
    }
}
