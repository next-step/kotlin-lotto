package stringcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class StringTokenizerTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1:2:3"])
    internal fun `쉼표 혹은 콜론 구분자로 분리하기`(numbersString: String) {
        val tokens: List<Int> = StringTokenizer.tokenize(numbersString)

        assertThat(tokens.size).isEqualTo(3);
        assertThat(tokens[0]).isEqualTo(1);
        assertThat(tokens[1]).isEqualTo(2);
        assertThat(tokens[2]).isEqualTo(3);
    }
}