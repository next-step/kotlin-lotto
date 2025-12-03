package domain.purchase

import domain.lotto.Lotto

const val LOTTO_PRICE = 1000

data class LottoPurchaseInfo(
    val amount: Int,
    val manualLottoNumbers: List<Lotto>,
) {
    val purchaseLottoCount: Int = amount / LOTTO_PRICE
    val change: Int = amount % LOTTO_PRICE
    val purchaseAmount: Int = purchaseLottoCount * LOTTO_PRICE
    val manualLottoCount: Int = manualLottoNumbers.size
    val autoLottoCount: Int = purchaseLottoCount - manualLottoNumbers.size

    init {
        require(amount > 0) { "구매 금액은 0원보다 커야 합니다. 입력한 구매금액: $amount" }

        require(manualLottoCount <= purchaseLottoCount) {
            "수동으로 구매하는 로또 개수는 총 구매 개수보다 많을 수 없습니다. 구매 개수: $purchaseLottoCount, 수동 구매 개수: $manualLottoCount"
        }
    }
}
