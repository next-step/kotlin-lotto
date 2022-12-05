package lotto.service

import io.kotest.matchers.collections.shouldContainExactly
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningStringParserTest {
    @Test
    internal fun `당첨번호는 숫자를 콤마(,)로 구분한 문자열을 받는다`() {
        val winningNumbers = WinningStringParser.parse("1,2,3,4,5,6")
        winningNumbers.numbers
            .map { it.value } shouldContainExactly listOf(1, 2, 3, 4, 5, 6)
    }

    @Test
    internal fun `숫자가 6개가 안되면 RuntimeException`() {
        assertThrows<IllegalArgumentException> { WinningStringParser.parse("1,2,3,4,5") }
    }

    @Test
    internal fun `숫자가 아닌 값이 들어오면 RuntimeException`() {
        assertThrows<IllegalArgumentException> { WinningStringParser.parse("1,$,3,4,5,6") }
    }
}
