package calculator.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CalculationTest {

    @Test
    @DisplayName("[1,2] 문자열이 입력된 경우 3")
    fun `1,2 If string is entered 3`() {
        val sum = Calculation.intArraySum(listOf(1, 2))
        assertThat(sum).isEqualTo(3)
    }
}
