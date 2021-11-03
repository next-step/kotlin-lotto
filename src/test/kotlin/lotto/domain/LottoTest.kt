package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 숫자 2개 맞았을 때 꽝`() {
        val numbers = listOf(1, 2, 0, 0, 0, 0)
        val winningNumber = WinningNumber(
            WinningNumbers(listOf(1, 2, 4, 5, 6, 7)), BonusNumber(8)
        )

        val lotto = Lotto(LottoNumbers(numbers), 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.BLANK, actual)
    }

    @Test
    fun `로또 숫자 1개 맞았을 때 꽝`() {
        val numbers = listOf(1, 0, 0, 0, 0, 0)
        val winningNumber = WinningNumber(
            WinningNumbers(listOf(1, 2, 4, 5, 6, 7)), BonusNumber(8)
        )

        val lotto = Lotto(LottoNumbers(numbers), 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.BLANK, actual)
    }

    @Test
    @DisplayName("로또 숫자 3개 맞았을 때 Rank.FOURTH")
    fun `로또 숫자 3개 맞았을 때 FOURTH`() {
        val numbers = listOf(1, 2, 4, 0, 0, 0)
        val winningNumber = WinningNumber(
            WinningNumbers(listOf(1, 2, 4, 5, 6, 7)), BonusNumber(8)
        )

        val lotto = Lotto(LottoNumbers(numbers), 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.FIFTH, actual)
    }

    @Test
    @DisplayName("로또 숫자 4개 맞았을 때 Rank.THIRD")
    fun `로또 숫자 4개 맞았을 때 THIRD`() {
        val numbers = listOf(1, 2, 4, 5, 0, 0)
        val winningNumber = WinningNumber(
            WinningNumbers(listOf(1, 2, 4, 5, 6, 7)), BonusNumber(8)
        )

        val lotto = Lotto(LottoNumbers(numbers), 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.FOURTH, actual)
    }

    @Test
    @DisplayName("로또 숫자 5개 맞고, 보너스 번호 안 맞을때 Rank.THIRD")
    fun `로또 숫자 5개 맞고, 보너스 번호 안 맞을때 THIRD`() {
        val numbers = listOf(1, 2, 4, 5, 6, 0)
        val winningNumber = WinningNumber(
            WinningNumbers(listOf(1, 2, 4, 5, 6, 7)), BonusNumber(8)
        )

        val lotto = Lotto(LottoNumbers(numbers), 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.THIRD, actual)
    }

    @Test
    @DisplayName("로또 숫자 5개 맞고, 보너스 번호 맞았을 때 Rank.SECOND")
    fun `로또 숫자 5개 맞고, 보너스 번호 맞았을 때 SECOND`() {
        val numbers = listOf(1, 2, 4, 5, 6, 8)
        val winningNumber = WinningNumber(
            WinningNumbers(listOf(1, 2, 4, 5, 6, 7)), BonusNumber(8)
        )

        val lotto = Lotto(LottoNumbers(numbers), 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.SECOND, actual)
    }

    @Test
    @DisplayName("로또 숫자 6개 맞았을 때 Rank.FIRST")
    fun `로또 숫자 6개 맞았을 때 FIRST`() {
        val numbers = listOf(1, 2, 4, 5, 6, 7)
        val winningNumber = WinningNumber(
            WinningNumbers(listOf(1, 2, 4, 5, 6, 7)), BonusNumber(8)
        )

        val lotto = Lotto(LottoNumbers(numbers), 1000)
        val actual = lotto.sortilege(winningNumber)

        assertEquals(Rank.FIRST, actual)
    }
}
