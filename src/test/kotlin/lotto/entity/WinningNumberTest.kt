package lotto.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WinningNumberTest {
    private val winningNumberList = listOf(1, 2, 3, 4, 5, 6)

    @DisplayName("당첨번호는 6자리 숫자를 가지고 있어야합니다.")
    @Test
    fun `winning numbers has six numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { WinningNumber.of(numbers) }
    }

    @DisplayName("6개 전부 매치 하면 1등입니다.")
    @Test
    fun `6 matches is first prize`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumber = WinningNumber.of(winningNumberList)
        val lottos = listOf(Lotto(numbers = numbers.map { LottoNumber(it) }.toSet()))
        assertEquals(1, winningNumber.calculateLottoResults(lottos)[Rank.First])
    }

    @DisplayName("5개 매치 하면 2등입니다.")
    @Test
    fun `5 matches is second prize`() {
        val numbers = listOf(1, 2, 3, 4, 5, 7)
        val winningNumber = WinningNumber.of(winningNumberList)
        val lottos = listOf(Lotto(numbers = numbers.map { LottoNumber(it) }.toSet()))
        assertEquals(1, winningNumber.calculateLottoResults(lottos)[Rank.Second])
    }

    @DisplayName("4개 매치 하면 3등입니다.")
    @Test
    fun `4 matches is third prize`() {
        val numbers = listOf(1, 2, 3, 4, 7, 8)
        val winningNumber = WinningNumber.of(winningNumberList)
        val lottos = listOf(Lotto(numbers = numbers.map { LottoNumber(it) }.toSet()))
        assertEquals(1, winningNumber.calculateLottoResults(lottos)[Rank.Third])
    }

    @DisplayName("3개 매치 하면 4등입니다.")
    @Test
    fun `3 matches is fourth prize`() {
        val numbers = listOf(1, 2, 3, 7, 8, 9)
        val winningNumber = WinningNumber.of(winningNumberList)
        val lottos = listOf(Lotto(numbers = numbers.map { LottoNumber(it) }.toSet()))
        assertEquals(1, winningNumber.calculateLottoResults(lottos)[Rank.Fourth])
    }

    @DisplayName("3개 매치 한게 두개면 4등이 두개입니다.")
    @Test
    fun `3 matches is fourth prize with 2 numbers`() {
        val numbers = listOf(1, 2, 3, 7, 8, 9)
        val winningNumber = WinningNumber.of(winningNumberList)
        val lottos = listOf(
            Lotto(numbers = numbers.map { LottoNumber(it) }.toSet()),
            Lotto(numbers = numbers.map { LottoNumber(it) }.toSet())
        )
        assertEquals(2, winningNumber.calculateLottoResults(lottos)[Rank.Fourth])
    }
}