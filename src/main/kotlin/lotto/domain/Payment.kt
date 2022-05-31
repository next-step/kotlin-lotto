package lotto.domain

@JvmInline
value class Payment(val cash: Int) {
    init {
        require(cash >= 1000) {
            "로또 구입은 최소 1000원부터 가능합니다."
        }
    }

    fun getAvailableNumberOfLotto(): Int {
        return cash / Lotto.LOTTO_PRICE
    }
}
