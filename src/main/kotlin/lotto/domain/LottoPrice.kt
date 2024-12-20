package lotto.domain

@JvmInline
value class LottoPrice(private val money: Int) {
    init {
        require(money >= LottoConstants.LOTTO_PRICE) { "로또 구입 금액은 1000원 이상이어야 합니다." }
    }

    val value: Int
        get() = money

    fun calculatePurchaseCount(): Int {
        return money / LottoConstants.LOTTO_PRICE
    }
}
