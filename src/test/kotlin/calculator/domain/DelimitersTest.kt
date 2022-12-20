package calculator.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class DelimitersTest {

    @Test
    fun `콤마와 콜론을 가지고 있는 구분자를 생성한다`() {
        // given
        val input = ""

        // when
        val actual = Delimiters.create(input).value.size

        // then
        val expected = 2
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `콤마와 콜론 외에 다른 문자도 포함된 구분자를 생성한다`() {
        // given
        val input = "//;\n1;2;-3"

        // when
        val actual = Delimiters.create(input).value.size

        // then
        val expected = 3
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    @DisplayName("//로 시작하여 \n로 끝나는 부분을 제거한다.")
    fun `입력값에 커스텀 구분자 추가하는 부분을 제거한다`() {
        // given
        val input = "//;\n1;2;-3"

        // when
        val actual = Delimiters().removeCustomRegex(input)

        // then
        val expected = "1;2;-3"
        assertThat(actual).isEqualTo(expected)
    }
}
