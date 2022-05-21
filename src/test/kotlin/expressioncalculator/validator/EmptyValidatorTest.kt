package expressioncalculator.validator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class EmptyValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "haha", "hoho"])
    @NullAndEmptySource
    fun `EmptyValidator는 input이 null이거나 비어있으면 유효하다`(input: String?) {
        val expected = input.isNullOrBlank()

        Assertions.assertThat(EmptyValidator.validate(input)).isEqualTo(expected)
    }
}
