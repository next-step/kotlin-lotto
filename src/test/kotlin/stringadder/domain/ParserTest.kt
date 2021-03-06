package stringadder.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ParserTest {

    @DisplayName("문자열을 입력 받은 경우 쉼표(,)와 콜론(:)을 기준으로 구분된 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1:2:3"])
    fun parse(input: String) {
        val expected = listOf(1, 2, 3)

        val actual = Parser(input).getOperands()

        Assertions.assertThat(actual).isEqualTo(expected)
    }
}