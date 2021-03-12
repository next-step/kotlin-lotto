package stringcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class StringTokenizerTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1:2:3", "1,2:3"])
    fun `쉼표 혹은 콜론 구분자로 분리하기`(numbersString: String) {
        val tokens: Tokens = StringTokenizer.tokenize(numbersString)

        assertThat(tokens.tokens.size).isEqualTo(3)
        assertThat(tokens.tokens[0].value).isEqualTo(1)
        assertThat(tokens.tokens[1].value).isEqualTo(2)
        assertThat(tokens.tokens[2].value).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//|\n1|2|3"])
    fun `커스텀 구분자로 분리하기`(numbersString: String) {

        val tokens: Tokens = StringTokenizer.tokenize(numbersString)

        assertThat(tokens.tokens.size).isEqualTo(3)
        assertThat(tokens.tokens[0].value).isEqualTo(1)
        assertThat(tokens.tokens[1].value).isEqualTo(2)
        assertThat(tokens.tokens[2].value).isEqualTo(3)
    }
}
