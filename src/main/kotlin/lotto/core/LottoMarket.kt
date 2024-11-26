package lotto.core

import lotto.core.constant.LottoConstants

object LottoMarket {
    fun purchase(purchaseAmount: String): Lottos {
        val purchasableCount = calculatePurchasableCount(purchaseAmount)
        val lottoList = issueLotto(purchasableCount)
        return Lottos(lottoList)
    }

    private fun calculatePurchasableCount(purchaseAmount: String): Int {

        val amount = purchaseAmount.toIntOrNull() ?: throw RuntimeException()
        return amount / LottoConstants.LOTTO_PRICE
    }

    private fun issueLotto(count: Int): List<Lotto> {
        return List(count) { Lotto() }
    }
}
