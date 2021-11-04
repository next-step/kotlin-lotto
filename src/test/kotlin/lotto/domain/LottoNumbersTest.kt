package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {
    @Test
    fun `로또 숫자 5개 일때 exception`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5)
            LottoNumbers(numbers)
        }
    }

    @Test
    fun `로또 숫자 7개 일때 exception`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
            LottoNumbers(numbers)
        }
    }

    @Test
    fun `인자로 주어진 리스트와 일치하는 개수 return`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 7, 8, 9))
        val lottoNumbers = LottoNumbers(numbers)

        val actual = lottoNumbers.getMatchCount(winningNumbers)

        assertEquals(3, actual)
    }

    @Test
    fun `보너스넘버가 존재한다면 true`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = LottoNumbers(numbers)

        val actual = lottoNumbers.isMatchedBonusNumber(BonusNumber(1))

        assertTrue(actual)
    }

    @Test
    fun `보너스넘버가 존재한지 않는다면 false`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = LottoNumbers(numbers)

        val actual = lottoNumbers.isMatchedBonusNumber(BonusNumber(7))

        assertFalse(actual)
    }
}
