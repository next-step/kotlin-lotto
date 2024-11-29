package lotto

import lotto.domain.LottoCalculator
import lotto.domain.LottoFactory
import lotto.domain.LottoResult
import lotto.domain.data.LottoWinPlace
import lotto.domain.data.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `{given} 로또 총 구매금액 1만 원 {when} LottoCalculator calculateLottoCount() {then} 10 반환`() {
        val totalPurchaseAmount = 10000
        val pricePerAmount = 1000
        val lottoCalculator = LottoCalculator(totalPurchaseAmount, pricePerAmount)
        val purchaseCount = lottoCalculator.calculateLottoCount()
        assertEquals(10, purchaseCount)
    }

    @Test
    fun `{given} 로또 총 10장 구매 {when} LottoGenerator generate() {then} 10개 리스트 반환`() {
        val purchaseCount = 10
        val lottoFactory = LottoFactory(purchaseCount)
        val list = lottoFactory.createLottoList()
        assertEquals(10, list.size)
    }
}
