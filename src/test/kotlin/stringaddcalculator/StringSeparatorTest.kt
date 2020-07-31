package stringaddcalculator

import org.assertj.core.api.Assertions.assertThat
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
}
