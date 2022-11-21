package stringcalculator.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal

class PositiveNumberTest {
    @Test
    internal fun `빈 문자열이 들어올 경우`() {
        val num = PositiveNumber.of("")
        assertThat(num.value).isEqualTo(BigDecimal.ZERO)
    }

    @Test
    internal fun `음수가 들어올 경우`() {
        assertThrows<IllegalArgumentException> { PositiveNumber.of("-1") }
    }

    @ParameterizedTest
    @ValueSource(strings = ["!", "@", "//"])
    internal fun `숫자 이외의 값이 들어올 경우`(value: String) {
        assertThrows<IllegalArgumentException> { PositiveNumber.of(value) }
    }

    @ParameterizedTest
    @CsvSource(value = ["1:2:3", "5:5:10", "1111:2222:3333"], delimiter = ':')
    internal fun `다른 숫자와 더한다`(addend: String, augend: String, expected: String) {
        val num1 = PositiveNumber.of(addend)
        val num2 = PositiveNumber.of(augend)
        val expectedNumber = PositiveNumber.of(expected)
        assertThat(num1.add(num2)).isEqualTo(expectedNumber)
    }
}
