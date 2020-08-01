package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class InputParserTest {

    @DisplayName("기본 구분자(, 또는 :)를 사용하여 숫자 리스트를 반환한다")
    @Test
    fun `default delimiter`() {
        assertThat(InputParser("1,2,3").numbersParsed).isEqualTo(listOf(1, 2, 3))
    }

    @DisplayName("커스텀 구분자(//와 \n 사이의 문자열)를 사용하여 숫자 리스트를 반환한다")
    @Test
    fun `custom delimiter`() {
        assertThat(InputParser("//;\\n1;2;3").numbersParsed).isEqualTo(listOf(1, 2, 3))
    }
}
