package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import stringcalculator.model.StringCalculator

class StringCalculatorTest {

    @DisplayName(value = "정상적인 숫자 구하기")
    @Test
    fun happyCase() {
        val list = listOf("3", "4", "5")
        assertThat(StringCalculator.sumString(list)).isSameAs(list.sumBy(String::toInt))
    }

    @DisplayName(value = "1개의 숫자 입력할 경우, 그대로 반환")
    @ParameterizedTest
    @ValueSource(strings = ["3", "0"])
    fun inputOnlyOneString(text: String) {
        assertThat(StringCalculator.sumString(listOf(text))).isSameAs(text.toInt())
    }

    @DisplayName(value = "아무것도 입력이 안됬을 경우, 0 리턴 ")
    @Test
    fun inputEmptyValueString() {
        val text = ""
        assertThat(StringCalculator.sumString(listOf(text))).isSameAs(0)
    }

    @DisplayName(value = "음수 및 숫자가 아닌 경우, RuntimeException")
    @ParameterizedTest
    @ValueSource(strings = ["-2", "d"])
    fun inputNegativeAndNonInteger(text: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                StringCalculator.sumString(listOf(text))
            }
    }
}
