package lotto.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumberParserTest {

    @Test
    fun `winning numbers are parsed by comma`() {
        val inputNumbers = "1,2,3,45,7,6"
        val expected = listOf(1, 2, 3, 45, 7, 6)

        val result = WinningNumberParser.parse(inputNumbers)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `non-digit inputs are removed from result`() {
        val inputNumbers = "1,2,3,this,7,6"
        val expected = listOf(1, 2, 3, 7, 6)

        val result = WinningNumberParser.parse(inputNumbers)

        assertThat(result).isEqualTo(expected)
    }
}
