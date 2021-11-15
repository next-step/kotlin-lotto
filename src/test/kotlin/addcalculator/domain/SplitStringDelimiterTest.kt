package addcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SplitStringDelimiterTest {

    @ParameterizedTest
    @CsvSource(value = ["3,2,3=3,2,3", "7:8,10=7,8,10"], delimiter = '=')
    fun `기본 구분자`(inputValue: String, expected: String) {
        assertThat(SplitStringDelimiter.splitValue(inputValue)).isEqualTo(expected.split(","))
    }

    @Test
    fun `커스텀 구분자`() {
        val inputValue = "//;\n1;2;3"
        val expected = "1,2,3"
        assertThat(SplitStringDelimiter.splitValue(inputValue)).isEqualTo(expected.split(","))
    }
}
