package lotto.domain

class PurchaseAmount(private val value: Int) {
    init {
        require(value >= LottoStore.LOTTO_PRICE) { "구입 금액은 ${LottoStore.LOTTO_PRICE}원 이상이어야 합니다." }
    }

    fun getValue(): Int = value

    fun calculateAutoTicketAmount(manualCount: TicketCount): PurchaseAmount {
        return PurchaseAmount(value - manualCount.getValue() * LottoStore.LOTTO_PRICE)
    }
}
