package stringcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TokensTest {

    @Test
    fun `문자열리스트를 입력받아 토큰리스트를 갖는다`() {
        val numberStringList = listOf("1", "2", "3", "4")
        val tokens = Tokens.from(numberStringList)
        assertThat(tokens.tokens.size).isEqualTo(numberStringList.size)
        tokens.tokens.forEachIndexed { i, token ->
            assertThat(token.value).isEqualTo(numberStringList[i].toInt())
        }
    }
}
