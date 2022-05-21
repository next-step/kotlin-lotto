package expressioncalculator.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class SingleIntegerValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "zz", "haha"])
    @NullAndEmptySource
    fun `SingleIntegerValidator는 input을 Int로 변환할 수 있을 경우 유효하다`(input: String?) {
        val expected = input?.toIntOrNull() != null

        assertThat(SingleIntegerValidator.validate(input)).isEqualTo(expected)
    }
}
