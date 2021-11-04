package lotto.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `인자의 개수가 5일때 exception`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5)
            WinningNumbers(numbers)
        }
    }

    @Test
    fun `인자의 개수가 7일때 exception`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
            WinningNumbers(numbers)
        }
    }

    @Test
    fun `인자로 건낸 Number 를 포함하고 있을경우 true`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(numbers)

        val actual = winningNumbers.contains(1)

        assertTrue(actual)
    }

    @Test
    fun `인자로 건낸 Number 를 포함하고 있지 않을경우 false`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(numbers)

        val actual = winningNumbers.contains(7)

        assertFalse(actual)
    }
}
