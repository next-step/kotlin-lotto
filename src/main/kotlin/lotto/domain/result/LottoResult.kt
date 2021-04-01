package lotto.domain.result

import lotto.domain.LottoStore.LOTTO_PRICE

class LottoResult(val result: Map<LottoRank, Int>) {
    val earning: Double
        get() = "%.2f".format((calculateProfit() / calculatePurchaseAmount())).toDouble()

    private fun calculateProfit() = result.map { it.key.prize * it.value }.sum().toDouble()

    private fun calculatePurchaseAmount() = (result.values.sum() * LOTTO_PRICE.price).toDouble()
}
