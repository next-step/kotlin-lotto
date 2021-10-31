package addcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringValueTest {

    @Test
    fun `null일 경우 0 return`() {
        assertThat(Value(null).number) isEualTo (0)
    }

    @Test
    fun `empty일 경우 0 return`() {
        assertThat(Value("").number) isEualTo (0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "String", "@", "!"])
    fun `양수가 아닌 문자열 또는 특수문자일 경우 예외`(inputString: String) {
        assertThrows<IllegalArgumentException> {
            Value(inputString)
        }
    }
}
