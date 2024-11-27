package lotto.domain.purchase

class LottoPurchaseCount(pay: Int, val manualLottoAmount: Amount) {
    val autoLottoAmount: Amount

    init {
        require(pay >= PRICE_PER_LOTTO) { PAY_MIN_EXCEPTION }
        require(pay >= PRICE_PER_LOTTO * manualLottoAmount.value) { PAY_OVER_EXCEPTION }
        val total = pay / PRICE_PER_LOTTO
        autoLottoAmount = Amount(total - manualLottoAmount.value)
    }

    companion object {
        private const val PAY_MIN_EXCEPTION = "최소 구매 금액이 1000원 이상이어야 합니다."
        private const val PAY_OVER_EXCEPTION = "수동 구매 금액이 결제 금액보다 클 수 없습니다."
        const val PRICE_PER_LOTTO = 1000
    }
}
