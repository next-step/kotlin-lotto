package stringAddCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TokensTest {
    @Test
    fun `다수의 토큰 값이 정상적으로 더해지는지 확인`() {
        // given
        val tokenList = listOf(
            Token(1),
            Token(2),
            Token(3)
        )
        val tokens = Tokens(tokenList)
        // when
        val result = tokens.sum()
        // then
        assertEquals(6, result)
    }
}
