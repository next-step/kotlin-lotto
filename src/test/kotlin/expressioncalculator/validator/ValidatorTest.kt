package expressioncalculator.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "haha", "hoho"])
    fun `Validator를 구현하여 input이 유효한지 검사할 수 있다`(input: String?) {
        val validator = object : Validator {
            override fun isValid(input: String?): Boolean {
                return !input.isNullOrEmpty()
            }
        }

        val expected = if (input.isNullOrEmpty()) {
            ValidateResult.Failed
        } else {
            ValidateResult.Success
        }

        assertThat(validator.validate(input)).isEqualTo(expected)
    }
}
