package calculator.separator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CustomSeparatorTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2,3|false",
            """//;\n|true""",
            """//;\n1|true""",
            """//;\n1;2;3|true"""
        ],
        delimiter = '|'
    )
    fun `식 처음에 연속된 두개의 슬래시와 개행문자 사이에 위치한 문자가 있다면 사용가능`(expression: String, expect: Boolean) {
        // given
        val separator = CustomSeparator()

        // when
        val canSeparate = separator.canSeparate(expression)

        // then
        assertThat(canSeparate).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            """//?\n|1""",
            """//;\n1|1""",
            """//;\n1;2;3|3"""
        ],
        delimiter = '|'
    )
    fun `커스텀 문자로 식을 분리한다`(expression: String, expect: Int) {
        // given
        val separator = CustomSeparator()

        // when
        val list = separator.separate(expression)

        // then
        assertThat(list).hasSize(expect)
    }
}
