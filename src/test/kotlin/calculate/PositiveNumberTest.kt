package calculate

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource

class PositiveNumberTest {
    @Test
    fun `문자면 IllegalArgumentException`() {
        val notNumber = "문자임"

        assertThatIllegalArgumentException().isThrownBy {
            PositiveNumber(notNumber)
        }
    }

    @ParameterizedTest
    @EmptySource
    fun `빈 문자는 예외`(text: String) {
        assertThatIllegalArgumentException().isThrownBy {
            PositiveNumber(text)
        }
    }
}
