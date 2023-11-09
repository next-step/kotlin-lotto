package study.lotto.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoesTest {
    @Test
    fun `Lottoes 객체는 올바른 개수의 Lotto 객체를 포함한다`() {
        val numberOfLottoes = 13
        val lottoes = Lottoes.buyLottoes(numberOfLottoes * Lotto.PRICE_PER_TICKET)
        assertEquals(numberOfLottoes, lottoes.count())
    }

    @Test
    fun `countMatches 함수가 정상적으로 일치 횟수를 반환해야 한다`() {
        val winningLotto = Lotto.get(listOf(1, 2, 3, 4, 5, 6))
        val lottos = Lottoes(listOf(winningLotto))
        val expectedMatches = listOf(6)

        val matches = lottos.countMatches(winningLotto)

        assertEquals(expectedMatches, matches)
    }

    @Test
    fun `Lotto를 구매할 때 구매금액이 음수일 경우 예외를 던져야 한다`() {
        val purchaseAmount = -100

        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            Lottoes.buyLottoes(purchaseAmount)
        }

        assertEquals("purchaseAmount must be a positive value", exception.message)
    }
}
