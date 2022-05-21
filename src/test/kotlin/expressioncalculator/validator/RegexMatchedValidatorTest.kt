package expressioncalculator.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class RegexMatchedValidatorTest {
    private val regex = Regex("//(.)\n(.*)")
    private val regexExistValidator = RegexMatchedValidator(regex)

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//a\n1;2;3", "/dn1;2;3"])
    @NullAndEmptySource
    fun `RegexMatchedValidator는 input이 지정한 정규식에 일치하면 유효하다`(input: String?) {
        val isMatched = input?.let {
            regex.matches(it)
        } ?: false

        val expected = if (isMatched) {
            ValidateResult.Success
        } else {
            ValidateResult.Failed
        }

        assertThat(regexExistValidator.validate(input)).isEqualTo(expected)
    }
}
