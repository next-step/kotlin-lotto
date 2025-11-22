package domain

const val LOTTO_PRICE = 1000

data class Amount(private val amount: Int) {
    init {
        require(amount > 0) { "구매 금액은 0원보다 커야 합니다. 입력한 구매금액: $amount" }
    }

    fun getPurchaseLottoCount() = amount / LOTTO_PRICE

    fun getChange() = amount % LOTTO_PRICE

    fun getPurchaseAmount() = getPurchaseLottoCount() * LOTTO_PRICE
}
