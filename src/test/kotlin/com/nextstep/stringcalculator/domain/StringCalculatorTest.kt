package com.nextstep.stringcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class StringCalculatorTest {
    @Test
    fun `커스텀 구분자가 없다면 기본 구분자로 이루어진 계산기를 생성한다`() {
        val calculator = StringCalculator("1;2;3")

        assertThat(calculator.delimeters.size).isEqualTo(2)
        assertThat(calculator.delimeters).contains(",")
        assertThat(calculator.delimeters).contains(";")
    }

    @Test
    fun `커스텀 구분자가 있다면 해당 구분자로 이루어진 계산기를 생성한다`() {
        val calculator = StringCalculator("//a\\n1a2a3")

        assertThat(calculator.delimeters.size).isEqualTo(1)
        assertThat(calculator.delimeters).contains("a")
    }

    @Test
    internal fun `숫자 중에 자연수가 아닌 수가 있다면 에러를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            StringCalculator("-1;2;3")
        }
    }

    @Test
    internal fun `입력값이 비어있으면 0을 리턴한다`() {
        val calculator = StringCalculator("")

        assertThat(calculator.numbers).hasSize(1)
        assertThat(calculator.numbers).contains(0)
    }

    @Test
    fun `split된 숫자들을 더하여 리턴해준다`() {
        val calculator = StringCalculator("//a\\n1a2a3")

        assertThat(calculator.calculate()).isEqualTo(6)
    }
}
