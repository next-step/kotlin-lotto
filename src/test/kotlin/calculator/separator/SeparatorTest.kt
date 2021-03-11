package calculator.separator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class SeparatorTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "1|1",
            "1,2|2",
            "1:2|2",
            "1,2:3|3",
            "1:2,3|3",
            """//?\n|1""",
            """//?\n1|1""",
            """//?\n1?2|2"""
        ],
        delimiter = '|'
    )
    fun `올바른 식을 주입하면 분리해준다`(expression: String, expect: Int) {
        // given

        // when
        val list = Separator.separate(expression)

        // then
        assertThat(list).hasSize(expect)
    }

    @Test
    fun `올바르지 않은 식을 주입하면 exception 발생`() {
        // given
        val wrongExpression = "1?2"
        // when

        // then
        assertThrows<IllegalArgumentException> { Separator.separate(wrongExpression) }
            .run { assertThat(this).hasMessageContaining("분해 할 수 없는 식($wrongExpression) 입니다.") }
    }
}
