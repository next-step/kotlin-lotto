package lotto

class LottoGame(val purchaseAmount: Int) {
    val ticketQuantity: Int

    init {
        require(purchaseAmount >= 1000) { "구매금액은 1000원 이상이어야 합니다. 입력한 구매 금액: $purchaseAmount" }
        ticketQuantity = purchaseAmount / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
