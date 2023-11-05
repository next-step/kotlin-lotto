package study.calculator

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PositiveNumberValidatorTest {
    private lateinit var validator: PositiveNumberValidator

    @BeforeEach
    fun setUp() {
        validator = PositiveNumberValidator()
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    fun negative() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { validator.validate(listOf(-1, 2, 3)) }
    }
}
