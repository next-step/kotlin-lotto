package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.RuntimeException

class InputParserTest {

    @DisplayName("기본 구분자(, 또는 :)를 사용하여 숫자 리스트를 반환한다")
    @Test
    fun `default delimiter`() {
        assertThat(InputParser("1,2:3").numbersParsed).isEqualTo(listOf(1, 2, 3))
    }

    @DisplayName("기본 구분자 외 커스텀 구분자(//와 \n 사이의 문자열)를 사용하여 숫자 리스트를 반환한다")
    @Test
    fun `custom delimiter`() {
        assertThat(InputParser("//;\\n1,2;3").numbersParsed).isEqualTo(listOf(1, 2, 3))
    }

    @DisplayName("입력값 중 음수가 있을 경우 RuntimeException을 발생시킨다")
    @Test
    fun `negative`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy{InputParser("1,-20").numbersParsed}
            .withMessage("숫자 이외의 값 또는 음수 입력 불가")
    }

    @DisplayName("구분자가 아닌 문자가 사용되었을 때 RuntimeException을 발생시킨다")
    @Test
    fun `illegal letter`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy{InputParser("1,1a,2").numbersParsed}
            .withMessage("숫자 이외의 값 또는 음수 입력 불가")
    }
}
