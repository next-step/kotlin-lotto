package lotto.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {

    @Test
    fun `당첨넘버와 보너스넘버가 중복될때 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            WinningNumber(numbers = numbers, 6)
        }
    }

    @Test
    fun `전달된 인자에 보너스번호가 포함된다면 true`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumber = WinningNumber(numbers = numbers, 7)

        val actual = winningNumber.isMatchedBonusNumber(listOf(7))

        assertTrue(actual)
    }

    @Test
    fun `전달된 인자에 보너스번호가 포함되지 않는다면 false`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumber = WinningNumber(numbers = numbers, 7)

        val actual = winningNumber.isMatchedBonusNumber(listOf(1))

        assertFalse(actual)
    }

    @Test
    fun `당첨번호 사이즈가 5일때 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5)
            WinningNumber(numbers = numbers, 8)
        }
    }

    @Test
    fun `당첨번호 사이즈가 7일때 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
            WinningNumber(numbers = numbers, 8)
        }
    }

    @Test
    fun `전달된 숫자가 당첨번호 안에 있다면 true`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumber = WinningNumber(numbers = numbers, 8)
        val actual = winningNumber.contain(1)

        assertTrue(actual)
    }

    @Test
    fun `전달된 숫자가 당첨번호 안에 없다면 false`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumber = WinningNumber(numbers = numbers, 8)
        val actual = winningNumber.contain(7)

        assertFalse(actual)
    }
}
