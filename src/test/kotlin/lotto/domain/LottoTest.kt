package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `Lotto 숫자 5개 일때 exception`() {
        val exception = assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5)
            Lotto(numbers, 1000)
        }
        val expected = "6개의 번호를 입력해야합니다."

        assertEquals(expected, exception.message)
    }

    @Test
    fun `Lotto 숫자 7개 일때 exception`() {
        val exception = assertThrows<IllegalArgumentException> {
            val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
            Lotto(numbers, 1000)
        }
        val expected = "6개의 번호를 입력해야합니다."

        assertEquals(expected, exception.message)
    }

    @Test
    fun `Lotto 숫자 6개 일때 생성 성공`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        Lotto(numbers, 1000)

        // success
    }

    @Test
    fun `로또 숫자 2개 맞았을 때 꽝`() {
        val numbers = listOf(1, 2, 0, 0, 0, 0)
        val winningNumber = WinningNumber(listOf(1, 2, 4, 5, 6, 7))

        val lotto = Lotto(numbers, 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.BLANK, actual)
    }

    @Test
    fun `로또 숫자 1개 맞았을 때 꽝`() {
        val numbers = listOf(1, 0, 0, 0, 0, 0)
        val winningNumber = WinningNumber(listOf(1, 2, 4, 5, 6, 7))

        val lotto = Lotto(numbers, 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.BLANK, actual)
    }

    @Test
    @DisplayName("로또 숫자 3개 맞았을 때 Rank.FOURTH")
    fun `로또 숫자 3개 맞았을 때 FOURTH`() {
        val numbers = listOf(1, 2, 4, 0, 0, 0)
        val winningNumber = WinningNumber(listOf(1, 2, 4, 5, 6, 7))

        val lotto = Lotto(numbers, 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.FOURTH, actual)
    }

    @Test
    @DisplayName("로또 숫자 4개 맞았을 때 Rank.THIRD")
    fun `로또 숫자 4개 맞았을 때 THIRD`() {
        val numbers = listOf(1, 2, 4, 5, 0, 0)
        val winningNumber = WinningNumber(listOf(1, 2, 4, 5, 6, 7))

        val lotto = Lotto(numbers, 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.THIRD, actual)
    }

    @Test
    @DisplayName("로또 숫자 4개 맞았을 때 Rank.SECOND")
    fun `로또 숫자 5개 맞았을 때 SECOND`() {
        val numbers = listOf(1, 2, 4, 5, 6, 0)
        val winningNumber = WinningNumber(listOf(1, 2, 4, 5, 6, 7))

        val lotto = Lotto(numbers, 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.SECOND, actual)
    }

    @Test
    @DisplayName("로또 숫자 4개 맞았을 때 Rank.FIRST")
    fun `로또 숫자 5개 맞았을 때 FIRST`() {
        val numbers = listOf(1, 2, 4, 5, 6, 7)
        val winningNumber = WinningNumber(listOf(1, 2, 4, 5, 6, 7))

        val lotto = Lotto(numbers, 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.FIRST, actual)
    }
}
