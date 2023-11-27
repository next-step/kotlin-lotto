package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoShopTest {
    @Test
    fun `로또를 구매할 경우 올바른 개수의 Lotto 객체를 포함한다`() {
        val numberOfLottoes = 13
        val buyingLottoesAmount = BuyingLottoesAmount.get(Amount(numberOfLottoes))
        val lottoes = LottoShop.buyLottoes(buyingLottoesAmount.getSpentAmount())
        assertEquals(buyingLottoesAmount.amount, lottoes.toTotalList().count())
    }

    @Test
    fun `수동으로 로또를 구매할 경우 올바른 개수의 Lotto 객체를 포함한다`() {
        val numberOfLottoes = 1
        val buyingLottoesAmount = BuyingLottoesAmount.get(Amount(numberOfLottoes))
        val markedLottoNumbersList = mutableListOf(LottoNumbers.get(1, 2, 3, 4, 5, 6))
        val lottoes = LottoShop.buyLottoes(buyingLottoesAmount.getSpentAmount(), markedLottoNumbersList)
        assertEquals(buyingLottoesAmount.amount, lottoes.toTotalList().count())
    }

    @Test
    fun `자동과 수동으로 로또를 구매할 경우 올바른 개수의 Lotto 객체를 포함한다`() {
        val numberOfLottoesManual = 1
        val numberOfLottoesAuto = 13
        val buyingLottoesAmount = BuyingLottoesAmount.get(Amount(numberOfLottoesManual + numberOfLottoesAuto))
        val markedLottoNumbersList = mutableListOf(LottoNumbers.get(1, 2, 3, 4, 5, 6))
        val lottoes = LottoShop.buyLottoes(buyingLottoesAmount.getSpentAmount(), markedLottoNumbersList)
        assertEquals(buyingLottoesAmount.amount, lottoes.toTotalList().count())
    }
}
