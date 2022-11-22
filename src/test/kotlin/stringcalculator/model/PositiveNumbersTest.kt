package stringcalculator.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositiveNumbersTest {
    @Test
    internal fun `숫자 문자열 리스트를 받는다`() {
        val strings = listOf("1", "2", "3", "4")
        val expected = strings.map { PositiveNumber.of(it) }
        val positiveNumbers = PositiveNumbers.of(strings)
        assertThat(positiveNumbers.value).isEqualTo(expected)
    }

    @Test
    internal fun `숫자가 아닌 값이 포함된 리스트`() {
        val strings = listOf("1", "&", "3", "4")
        assertThrows<IllegalArgumentException> { PositiveNumbers.of(strings) }
    }
}
