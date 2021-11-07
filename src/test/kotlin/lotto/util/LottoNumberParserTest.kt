package lotto.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberParserTest {
    @Test
    fun `1,2,3,4,5,6 입력시 listOf(1,2,3,4,5,6) 반환`() {
        val input = "1,2,3,4,5,6"

        val actual = LottoNumberParser.parse(input)

        assertEquals(listOf(1, 2, 3, 4, 5, 6), actual)
    }

    @Test
    fun `, 로만 이루어졌을 경우 exception`() {
        assertThrows<IllegalArgumentException> {
            val input = ",,,,,"

            LottoNumberParser.parse(input)
        }
    }

    @Test
    fun `문자가 포함됐을경우 경우 exception`() {
        assertThrows<IllegalArgumentException> {
            val input = "1,2,ㅁ"

            LottoNumberParser.parse(input)
        }
    }
}
