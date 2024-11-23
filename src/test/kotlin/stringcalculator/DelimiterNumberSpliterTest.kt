package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DelimiterNumberSpliterTest {
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//;\n1;2*3"])
    fun `구분자 파싱 테스트`(input: String) {
        val delimiterNumberSpliter = DelimiterNumberSpliter()
        assertThat(delimiterNumberSpliter.findDelimiter(input)).isEqualTo(",|:|;")
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `숫자 파싱 테스트`(input: String) {
        val delimiterNumberSpliter = DelimiterNumberSpliter()
        assertThat(delimiterNumberSpliter.excludeDelimiter(input)).isEqualTo("1;2;3")
    }
}
