package stringaddcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringSeparatorTest {

    @ValueSource(strings = ["1,2,3", "1:2:3", "1,2:3"])
    @ParameterizedTest
    fun `기본 구분자를 가지는 문자열을 쪼개준다`(inputString: String) {
        // given
        val expectedTokens = listOf("1", "2", "3")

        // when
        val separatedToken = StringSeparator.separate(inputString)

        // then
        assertThat(separatedToken).isEqualTo(expectedTokens)
    }

    @Test
    fun `커스텀 구분자를 가지는 문자열을 쪼개준다`() {
        // given
        val stringHavingCustom = "//;\n1;2;3"
        val expectedTokens = listOf("1", "2", "3")

        // when
        val separatedToken = StringSeparator.separate(stringHavingCustom)

        // then
        assertThat(separatedToken).isEqualTo(expectedTokens)
    }

    @ValueSource(strings = ["/;\n1;2;3", "//;\\1;2;3", "asdfef"])
    @ParameterizedTest
    fun `유효하지 않은 문자열 입력시 Exception`(invalidString: String) {
        // then
        assertThatThrownBy { StringSeparator.separate(invalidString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("$invalidString 는 유효하지 않은 문자열입니다.")
    }
}
