package domain

const val LOTTO_PRICE = 1000

data class LottoPurchaseInfo(
    val amount: Int,
    val manualLottoCount: Int,
) {
    init {
        require(amount > 0) { "구매 금액은 0원보다 커야 합니다. 입력한 구매금액: $amount" }
        require(manualLottoCount > 0) { "로또 수는 1 이상이어야 합니다. 입력한 로또 수: $manualLottoCount" }
    }

    fun calculatePurchaseLottoCount() = amount / LOTTO_PRICE

    fun calculateChange() = amount % LOTTO_PRICE

    fun calculatePurchaseAmount() = calculatePurchaseLottoCount() * LOTTO_PRICE

    fun calculateAutoLottoCount() = calculatePurchaseLottoCount() - manualLottoCount
}
