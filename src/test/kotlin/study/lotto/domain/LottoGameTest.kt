package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `LottoGame 생성 시 구매금액이 음수일 경우 예외를 던져야 한다`() {
        val purchaseAmount = -100

        val exception = assertThrows(IllegalArgumentException::class.java) {
            LottoGame(purchaseAmount)
        }

        assertEquals("purchaseAmount must be a positive value", exception.message)
    }

    @Test
    fun `LottoGame 생성 시 구매금액이 양수일 경우 buyingLottoes를 생성해야 한다`() {
        val purchaseAmount = 10000

        val lottoGame = LottoGame(purchaseAmount)

        assertEquals(purchaseAmount / Lotto.PRICE_PER_TICKET, lottoGame.buyingLottoes.size)
    }
}
