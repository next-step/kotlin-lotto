package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class PositiveNumberTest {
    @Test
    fun `문자면 IllegalArgumentException`() {
        val notNumber = "문자임"

        assertThatIllegalArgumentException().isThrownBy {
            PositiveNumber(notNumber)
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자는 0`(text: String?) {
        val actual = PositiveNumber(text)

        assertThat(actual).isEqualTo(PositiveNumber(0))
    }
}
