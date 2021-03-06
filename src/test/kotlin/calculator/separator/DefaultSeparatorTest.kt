package calculator.separator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

internal class DefaultSeparatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈칸과 널을 입력해도 분리할 수 있다`(expression: String?) {
        //given
        val separator = DefaultSeparator()

        //when
        val canSeparate = separator.canSeparate(expression)

        //then
        assertThat(canSeparate).isTrue()
    }

    @ParameterizedTest
    @CsvSource(value = [
        "1|true",
        "1,2|true",
        "1:2|true",
        "1,2:3|true",
        "1,2?3|false",
        "1?2|false"
    ], delimiter = '|')
    fun `기본 분리기는 숫자와 쉼표와 콜론을 제외한 문자가 있어서는 안된다`(expression: String, expect: Boolean) {
        //given
        val separator = DefaultSeparator()

        //when
        val canSeparate = separator.canSeparate(expression)

        //then
        assertThat(canSeparate).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["1|1", "1,2|2", "1:2|2", "1,2:3|3"], delimiter = '|')
    fun `기본 분리기는 쉼표와 콜론를 기준으로 분리한다`(expression: String, expect: Int) {
        //given
        val separator = DefaultSeparator()

        //when
        val list = separator.separate(expression)

        //then
        assertThat(list).hasSize(expect)
    }

    @NullAndEmptySource
    @ParameterizedTest
    fun `빈 문자열 , null 인경우 빈 리스트를 반환한다`(expression: String?) {
        //given
        val separator = DefaultSeparator()

        //when
        val list = separator.separate(expression)

        //then
        assertThat(list).hasSize(0)
    }
}
