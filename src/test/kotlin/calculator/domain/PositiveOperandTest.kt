package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositiveOperandTest {
    @DisplayName("PositiveOperand 생성 테스트")
    @Test
    fun `PositiveOperand 생성 테스트`() {
        // given
        val expected = PositiveOperand(0)

        // when
        val result = PositiveOperand(0)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @DisplayName("PositiveOperand 부생성 테스트")
    @Test
    fun `PositiveOperand 부생성 테스트`() {
        // given
        val expected = PositiveOperand("0")

        // when
        val result = PositiveOperand("0")

        // then
        assertThat(result).isEqualTo(expected)
    }

    @DisplayName("음수 피연산자에 대한 예외처리 테스트")
    @Test
    fun `음수 피연산자에 대한 예외처리 테스트`() {
        // given, when, then
        assertThatThrownBy { PositiveOperand(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("음수는 입력할 수 없습니다.")
    }

    @DisplayName("입력된 값이 숫자인지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "a", "1a", "a1", "1 1", " 1", "1 "])
    fun `입력된 값이 숫자인지 확인하는 테스트`(input: String) {
        // when, then
        assertThatThrownBy { PositiveOperand(input) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessageContaining("숫자 이외의 값은 입력할 수 없습니다.")
    }
}
