package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringsTest {
    @ParameterizedTest
    @CsvSource(value = ["1;2;3:1,2,3", "3;4;5:3,4,5"], delimiter = ':')
    fun `기본 구분자로 파싱`(input: String, expected: String) {
        assertThat(Strings.parse(input).joinToString(","))
            .isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["1;2;3:;:1,2,3", "3^4^5^6:^:3,4,5,6"], delimiter = ':')
    fun `커스텀 구분자로 파싱`(input: String, delmiter: String, expected: String) {
        assertThat(Strings.parse(input, delmiter).joinToString(","))
            .isEqualTo(expected)
    }
}
