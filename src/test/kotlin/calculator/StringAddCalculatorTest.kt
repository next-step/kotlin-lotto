package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun `set up`() {
        calculator = StringAddCalculator()
    }

    @DisplayName("입력값이 비어 있을 때(공백 or Null), 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    fun `empty or null`(text: String?) {
        assertThat(calculator.add(text)).isZero()
    }

    @DisplayName("입력값 중 음수가 있을 경우 RuntimeException을 발생시킨다.")
    @Test
    fun `negative`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.add("-1") }.withMessage("음수 입력 불가")
    }
}
