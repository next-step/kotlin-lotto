package addcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringValueTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `null일 경우 0 return`(inputText: String?) {
        assertThat(StringValue(inputText).number).isZero
    }

    @ParameterizedTest
    @ValueSource(strings = ["String", "@", "!"])
    fun `양수가 아닌 문자열 또는 특수문자일 경우 예외`(inputString: String) {
        assertThrows<IllegalArgumentException> {
            StringValue(inputString)
        }
    }

    @Test
    fun `양수가 아닌 음수일 경우 예외`() {
        assertThrows<IllegalArgumentException> {
            StringValue("-1")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "123", "987"])
    fun `green case`(inputText: String) {
        assertThat(StringValue(inputText).number).isEqualTo(inputText.toInt())
    }
}
