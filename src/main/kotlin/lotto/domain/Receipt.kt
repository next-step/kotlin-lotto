package lotto.domain

class Receipt(val payment: Int) {
    init {
        require(payment > 0) { "지불금액은 0원 이상인 숫자여야 합니다." }
    }

    val lottoCount
        get() = payment / LOTTO_PRICE

    fun buyPrice() = lottoCount * LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
