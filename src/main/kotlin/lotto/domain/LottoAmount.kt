package lotto.domain

class LottoAmount(private val amount: Int) {
    val ticketCount: Int
        get() = amount / LOTTO_PRICE

    init {
        require(amount >= LOTTO_PRICE && amount % LOTTO_PRICE == 0) {
            "구입 금액은 1000원 단위여야 합니다. amount : $amount"
        }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
