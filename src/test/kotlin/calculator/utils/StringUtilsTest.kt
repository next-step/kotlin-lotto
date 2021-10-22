package calculator.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringUtilsTest {

    @Test
    fun `문자열을 컴마를 기준으로 숫자 목록으로 리턴한다`() {
        // given
        val givenText = "1,2,3"

        // when
        val actual = StringUtils.parseToNumbers(givenText)

        // then
        assertThat(actual).containsExactly(1, 2, 3)
    }

    @Test
    fun `문자열을 콜론을 기준으로 숫자 목록으로 리턴한다`() {
        // given
        val givenText = "1,2:3"

        // when
        val actual = StringUtils.parseToNumbers(givenText)

        // then
        assertThat(actual).containsExactly(1, 2, 3)
    }

    @Test
    fun `커스텀 구분자를 구분자를 지정하여 숫자 목록으로 리턴한다`() {
        // given
        val texts = "//;\n1;2;3"

        // when
        val actual = StringUtils.parseToNumbers(texts)

        // then
        assertThat(actual).containsExactly(1, 2, 3)
    }
}
