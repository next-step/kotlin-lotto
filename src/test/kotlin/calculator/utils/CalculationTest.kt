package calculator.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CalculationTest {

    @Test
    @DisplayName("[1,2] 문자열이 입력된 경우 3")
    fun `1,2 If string is entered 3`() {
        val sum = Calculation.stringArraySum(listOf("1", "2"))
        assertThat(sum).isEqualTo(3)
    }

    @Test
    @DisplayName("문자 입력 중 숫자 이외의 값이 포함된 경우 RuntimeException 오류")
    fun `RuntimeException error when character input contains non-numeric values`() {
        assertThrows<RuntimeException> { Calculation.stringArraySum(listOf("a", "2")) }
    }

    @Test
    @DisplayName("문자 입력 중 음수 값이 포함된 경우 RuntimeException 오류")
    fun `RuntimeException error when character input contains negative values`() {
        assertThrows<RuntimeException> { Calculation.stringArraySum(listOf("-3", "2")) }
    }
}
