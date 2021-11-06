package lotto.domain

import lotto.domain.model.LottoNumber
import lotto.domain.model.WinningNumbers
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `당첨번호의 개수가 5일때 exception`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
            )
            WinningNumbers(numbers)
        }
    }

    @Test
    fun `당첨번호의 개수가 7일때 exception`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
                LottoNumber(7),
            )
            WinningNumbers(numbers)
        }
    }

    @Test
    fun `로또번호가 당첨번호 안에 포함될경우 true`() {
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )
        val winningNumbers = WinningNumbers(numbers)

        val actual = winningNumbers.contains(LottoNumber(1))

        assertTrue(actual)
    }

    @Test
    fun `로또번호가 당첨번호 안에 포함하고 있지 않은경우 false`() {
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )
        val winningNumbers = WinningNumbers(numbers)

        val actual = winningNumbers.contains(LottoNumber(7))

        assertFalse(actual)
    }
}
