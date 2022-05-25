package com.nextstep.jngcii.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `list 내부 정수 총합 테스트`() {
        val numbers = listOf(1, 2, 3)

        val actual = Calculator.run(numbers)

        assertThat(actual).isEqualTo(6)
    }
}
