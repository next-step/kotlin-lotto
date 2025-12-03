package domain.purchase

import domain.lotto.Lotto

const val LOTTO_PRICE = 1000

data class LottoPurchaseInfo(
    val amount: Int,
    val manualLottoNumbers: List<Lotto>,
) {
    init {
        require(amount > 0) { "구매 금액은 0원보다 커야 합니다. 입력한 구매금액: $amount" }
    }

    fun calculatePurchaseLottoCount() = amount / LOTTO_PRICE

    fun calculateChange() = amount % LOTTO_PRICE

    fun calculatePurchaseAmount() = calculatePurchaseLottoCount() * LOTTO_PRICE

    fun calculateAutoLottoCount() = calculatePurchaseLottoCount() - manualLottoNumbers.size
}
