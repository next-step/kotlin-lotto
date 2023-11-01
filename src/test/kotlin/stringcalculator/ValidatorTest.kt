package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1:2:3:true", "!:1:2:false", "1:a:3:false", "3,4,-2:false"], delimiter = ':')
    fun `모든 문자가 0보다 큰 숫자 인지 확인한다`(value1: String, value2: String, value3: String, expected: Boolean) {
        // given
        val validator = Validator()
        val target = listOf(value1, value2, value3)

        // when
        val result = validator.ensureAllPositiveNumbers(target)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `문자가 0보다 큰 숫자 인이면 예외를 던지지 않는다`(value: String) {
        // given
        val validator = Validator()

        // when
        validator.ensurePositiveNumber(value)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-2", "a", "!", " ",""])
    fun `문자가 0보다 큰 숫자가 아니면 예외를 던진다`(target: String) {
        // given
        val validator = Validator()

        // when
        val result = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            validator.ensurePositiveNumber(target)
        }

        // then
        assertThat(result.message).isEqualTo("0보다 큰 숫자 이여야 한다.")
    }

}
