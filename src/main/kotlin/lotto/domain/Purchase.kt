package lotto.domain

class Purchase(
    amount: Int = 0
) {
    var amount = amount
        private set

    init {
        require(amount > 0 && amount % LOTTO_PRICE == 0) {
            "구매 금액은 최소 천원부터, 천원단위로만 구매 가능합니다."
        }
    }

    fun quantity(): Int {
        return amount / 1000
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
