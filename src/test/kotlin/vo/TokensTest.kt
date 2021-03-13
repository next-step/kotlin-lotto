package vo

import calculator.vo.Token
import calculator.vo.Tokens
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class TokensTest {
    @Test
    @DisplayName("문자열 리스트를 token 리스트로 변환한다")
    internal fun convertStr2TokenListTest() {
        val input = listOf("1", "2", "3")
        assertThat(Tokens.of(input).tokens)
            .containsExactly(Token(1), Token(2), Token(3))
    }

    @Test
    @DisplayName("Tokens의 총 합을 변환한다")
    internal fun sumOfTokensTest() {
        val input = listOf("1", "2", "3")
        assertThat(Tokens.of(input).sum()).isEqualTo(6)
    }
}
