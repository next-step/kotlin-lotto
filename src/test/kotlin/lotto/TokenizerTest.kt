package lotto

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TokenizerTest {

    @DisplayName("입력된 문장을 구분자를 통해서 분리한다.")
    @ParameterizedTest
    @ValueSource(
        strings = ["fog,james,jay", "fog, james, jay"]
    )
    fun tokenize(input: String) {
        val list = listOf("fog", "james", "jay")
        val result = Tokenizer.tokenize(input)

        assertThat(result).isEqualTo(list)
    }

    @DisplayName("입력된 문장을 특정 구분자를 통해서 분리한다.")
    @ParameterizedTest
    @ValueSource(
        strings = ["//;\nfog;james;jay", "//;\nfog; james; jay"]
    )
    fun customTokenize(input: String) {
        val list = listOf("fog", "james", "jay")
        val result = Tokenizer.tokenize(input)

        assertThat(result).isEqualTo(list)
    }
}
