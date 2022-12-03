package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {
    @Test
    fun `로또 번호 입력 - 구분자 파싱 테스트`() {
        // given
        val expected = listOf(1, 2, 3, 4, 5, 6)

        // when
        val actual = InputParser.parseWithDelimiter("1, 2, 3, 4, 5, 6")

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "Lotto"])
    fun `로또 번호 입력 - 예외처리 테스트`(input: String) {
        // when, then
        assertThatThrownBy { InputParser.parseWithDelimiter(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자 이외의 값은 입력할 수 없습니다.")
    }
}
