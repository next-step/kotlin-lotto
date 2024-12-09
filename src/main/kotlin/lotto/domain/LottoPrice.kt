package lotto.domain

@JvmInline
value class LottoPrice(val money: Int) {
    init {
        require(money >= LottoConstants.LOTTO_PRICE) { "로또 구입 금액은 1000원 이상이어야 합니다." }
    }

    fun calculatePurchaseCount(): Int {
        return money / LottoConstants.LOTTO_PRICE
    }
}
