package calculator.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringUtilsTest {

    @Test
    fun `문자열을 구분자를 기준으로 문자 목록으로 리턴한다`() {
        // given
        val givenText = "a,b:c"
        val givenDelimiter = ",|:"

        // when
        val actual = StringUtils.splitTextByDelimiter(givenText, givenDelimiter)

        // then
        assertThat(actual).containsExactly("a", "b", "c")
    }

    @Test
    fun `문자 목록을 숫자 목록으로 리턴한다`() {
        // given
        val texts = listOf("1", "2", "3")

        // when
        val actual = StringUtils.toNumbers(texts)

        // then
        assertThat(actual).containsExactly(1, 2, 3)
    }
}
