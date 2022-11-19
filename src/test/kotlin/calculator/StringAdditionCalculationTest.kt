package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class StringAdditionCalculationTest {

    private lateinit var calculator: StringAdditionCalculator

    @BeforeEach
    fun beforeAll() {
        calculator = StringAdditionCalculator()
    }

    @Test
    @DisplayName("1,2:3 문자열이 입력된 경우 6")
    fun `If a string is entered, 6`() {
        val main = calculator.main("1,2:3")
        assertThat(main).isEqualTo(6)
    }

    @Test
    @DisplayName("공백 문자열이 입력된 경우 0")
    fun `If blank string is entered, 0`() {
        val main = calculator.main("")
        assertThat(main).isEqualTo(0)
    }

    @Test
    @DisplayName("//;\n1;2;3 입력된 경우 6")
    fun `If a normal value is entered`() {
        val main = calculator.main("//;\n1;2;3")
        assertThat(main).isEqualTo(6)
    }
}
