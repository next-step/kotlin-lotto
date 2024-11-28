package calculator

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun `음수가 포함되어 있으면 예외가 발생한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Numbers.from(listOf(-1, 2, 3))
        }.withMessage("음수는 허용되지 않습니다.")
    }

    @Test
    fun `양수들의 합을 계산한다`() {
        val numbers = Numbers.from(listOf(1, 2, 3))
        assertEquals(6, numbers.sum())
    }
}
