package lotto.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `당첨번호의 개수가 5일때 exception`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5)
            WinningNumbers(numbers)
        }
    }

    @Test
    fun `당첨번호의 개수가 7일때 exception`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
            WinningNumbers(numbers)
        }
    }

    @Test
    fun `로또번호가 당첨번호 안에 포함될경우 true`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(numbers)

        val actual = winningNumbers.contains(1)

        assertTrue(actual)
    }

    @Test
    fun `로또번호가 당첨번호 안에 포함하고 있지 않은경우 false`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(numbers)

        val actual = winningNumbers.contains(7)

        assertFalse(actual)
    }
}
