package calculator

import annotation.NullAndBlankStringSource
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

class StringAddCalculatorTest {
    @DisplayName("공백 문자열 또는 null이 입력될 경우 0을 반환한다")
    @ParameterizedTest
    @NullAndBlankStringSource
    fun blankOrNull(text: String?) {
        val actual = StringAddCalculator.add(text)

        assertThat(actual).isEqualTo(0)
    }

    @DisplayName("숫자 하나가 입력될 경우 해당 숫자를 반환한다")
    @Test
    fun oneNumber() {
        val text = "1"

        val actual = StringAddCalculator.add(text)

        assertThat(actual).isEqualTo(1)
    }

    @DisplayName("쉼표 또는 콜론을 구분자로 가지는 문자열이 입력될 경우 구분자를 기준으로 분리한 숫자의 합을 반환한다")
    @Test
    fun delimiter() {
        val text = "1,2:3"

        val actual = StringAddCalculator.add(text)

        assertThat(actual).isEqualTo(6)
    }

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 경우 커스텀 구분자를 기준으로 분리한 숫자의 합을 반환한다")
    @Test
    fun customDelimiter() {
        val text = "//;\n1;2;3"

        val actual = StringAddCalculator.add(text)

        assertThat(actual).isEqualTo(6)
    }

    @DisplayName("숫자 이외의 값이 입력될 경우 RuntimeException을 던진다")
    @Test
    fun noNumber() {
        val text = "a"

        val actual = Assertions.catchThrowable {
            StringAddCalculator.add(text)
        }

        assertThat(actual).isInstanceOf(RuntimeException::class.java)
            .hasMessageContaining("숫자 이외의 값은 계산할 수 없습니다.")
    }

    @DisplayName("음수가 입력될 경우 RuntimeException을 던진다")
    @Test
    fun negative() {
        val text = "-1"

        val actual = Assertions.catchThrowable {
            StringAddCalculator.add(text)
        }

        assertThat(actual).isInstanceOf(RuntimeException::class.java)
            .hasMessageContaining("음수는 계산할 수 없습니다.")
    }
}
