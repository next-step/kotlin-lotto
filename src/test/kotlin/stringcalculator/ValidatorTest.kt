package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ValidatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1:2:3:true", "!:1:2:false", "1:a:3:false", "3,4,-2:false"], delimiter = ':')
    fun `모든 문자가 0보다 큰 숫자 인지 확인한다`(value1: String, value2: String, value3: String, expected: Boolean) {
        // given
        val validator = Validator()
        val target = listOf(value1, value2, value3)

        // when
        val result = validator.areAllPositiveNumbers(target)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
