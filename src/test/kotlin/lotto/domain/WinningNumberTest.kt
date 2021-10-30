package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {

    @Test
    fun `인자의 사이즈가 6일때 정상생성`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        WinningNumber(numbers = numbers)

        // success
    }

    @Test
    fun `인자의 사이즈가 5일때 생성 실패`() {
        val exception = assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5)
            WinningNumber(numbers = numbers)
        }

        assertEquals("당첨번호는 6개여야 합니다.", exception.message)
    }

    @Test
    fun `인자의 사이즈가 7일때 생성 실패`() {
        val exception = assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
            WinningNumber(numbers = numbers)
        }

        assertEquals("당첨번호는 6개여야 합니다.", exception.message)
    }

    @Test
    fun `전달된 인자가 당첨번호 안에 있다면 true`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumber = WinningNumber(numbers = numbers)
        val actual = winningNumber.contain(1)

        assertTrue(actual)
    }

    @Test
    fun `전달된 인자가 당첨번호 안에 없다면 false`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumber = WinningNumber(numbers = numbers)
        val actual = winningNumber.contain(7)

        assertFalse(actual)
    }
}
