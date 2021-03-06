package stringadder.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class OperandNumberTest {

    @DisplayName("인자로 양수가 들어온 경우 객체 생성")
    @Test
    fun validate() {
        assertThat(OperandNumber("1")).isNotNull
    }

    @DisplayName("인자로 숫자가 아닌 값이 들어온 경우 예외 발생")
    @Test
    fun validateNumber() {
        assertThatThrownBy { OperandNumber("a") }
            .isInstanceOf(RuntimeException::class.java)
    }

    @DisplayName("인자로 음수가 들어온 경우 예외 발생")
    @Test
    fun validatePositive() {
        assertThatThrownBy { OperandNumber("-1") }
            .isInstanceOf(RuntimeException::class.java)
    }
}