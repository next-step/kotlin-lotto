package stringcalculator.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class FormulaTest {
    @DisplayName(value = "Formula에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    fun negative() {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { Formula.of("-1") }
    }

    @DisplayName(value = "Formula에 empty 혹은 null을 전달하면 0으로 평가식이 나온다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun nullOrEmpty(text: String?) {
        assertEquals("0", Formula.of(text).expression)
    }

    @DisplayName(value = "Formula에 숫자가 아닌 문자열을 전달하면 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["jeff", "jeff:2:45", "//j\n3j4jdl"])
    fun nonNumberString() {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { Formula.of("-1") }
    }
}
