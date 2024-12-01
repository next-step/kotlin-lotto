package lotto.domain

class PurchaseAmount(private val amount: Int) {
    init {
        require(amount >= LottoStore.LOTTO_PRICE) {
            "구입 금액은 ${LottoStore.LOTTO_PRICE}원 이상이어야 합니다."
        }
    }

    fun getValue(): Int = amount
}
