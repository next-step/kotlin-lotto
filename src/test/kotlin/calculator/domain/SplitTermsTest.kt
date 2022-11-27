package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SplitTermsTest {

    @Test
    fun `입력값을 이용하여 문자열 자르기 조건을 만든다`() {
        // given
        val input = "//;\n1;2;3"

        // when
        val actual = SplitTerms.create(input).value

        // then
        val result = listOf(",", ":", ";")
        assertThat(actual).isEqualTo(result)
    }

}