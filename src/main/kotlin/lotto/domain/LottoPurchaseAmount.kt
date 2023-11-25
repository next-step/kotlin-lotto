package lotto.domain

import lotto.error.InvalidLottoAmountException

data class LottoPurchaseAmount(
    val purchaseAmount: Amount,
    val lottoPrice: Amount,
) {
    init {
        require(purchaseAmount % lottoPrice == 0) { throw InvalidLottoAmountException() }
    }

    val purchasedCount: Int
        get() = purchaseAmount / lottoPrice
}
