package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoShopTest {
    @Test
    fun `로또를 구매할 경우 올바른 개수의 Lotto 객체를 포함한다`() {
        val numberOfLottoes = 13
        val lottoes = LottoShop.buyLottoes(
            Amount(numberOfLottoes * Lotto.PRICE_PER_TICKET)
        )
        assertEquals(numberOfLottoes, lottoes.getAll().count())
    }
}
