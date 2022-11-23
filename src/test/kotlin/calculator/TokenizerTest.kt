package calculator

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class TokenizerTest {

    @DisplayName("입력된 문장을 구분자를 통해서 분리한다.")
    @ParameterizedTest
    @ValueSource(
        strings = ["1,2,3,4,5,6", "1, 2, 3, 4, 5, 6"]
    )
    fun tokenize(input: String) {
        val list = listOf("1", "2", "3", "4", "5", "6")
        val result = Tokenizer.tokenize(input)

        assertThat(result).isEqualTo(list)
    }
}
