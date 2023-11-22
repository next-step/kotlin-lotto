package study.lotto.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BuyingLottoesAmountTest {

    @Test
    fun `구매한 로또의 양은 주어진 금액과 일치하여야 한다`() {
        val buyingCount = 13
        val buyingLottoesAmount = BuyingLottoesAmount(Amount(buyingCount * BuyingLottoesAmount.PRICE_PER_TICKET))

        Assertions.assertEquals(buyingLottoesAmount.amount, buyingCount)
    }

    @Test
    fun `구매한 로또의 총 금액은 주어진 금액과 일치하여야 한다`() {
        val purchase = 13 * BuyingLottoesAmount.PRICE_PER_TICKET
        val buyingLottoesAmount = BuyingLottoesAmount(Amount(purchase))

        Assertions.assertEquals(buyingLottoesAmount.getSpentAmount().amount, purchase)
    }

    @Test
    fun `로또의 개수로 총 구매한 금액을 계산할 수 있다`() {
        val buyingCount = 13
        val buyingLottoesAmount = BuyingLottoesAmount.get(Amount(buyingCount))

        Assertions.assertEquals(buyingLottoesAmount.amount, buyingCount)
    }
}
