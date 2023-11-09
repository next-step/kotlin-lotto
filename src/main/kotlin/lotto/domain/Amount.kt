package lotto.domain

data class Amount(val amount: Int) {

    init {
        require(amount >= LottoVendingMachine.LOTTO_PRICE) { "구입 금액은 최소 ${LottoVendingMachine.LOTTO_PRICE}원 이상이어야 합니다." }
    }

    fun purchasableCount(): Int {
        return amount / LottoVendingMachine.LOTTO_PRICE
    }
}
