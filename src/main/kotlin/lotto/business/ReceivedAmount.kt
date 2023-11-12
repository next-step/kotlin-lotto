package lotto.business

class ReceivedAmount(val amount: Int) {

    init {
        require(amount >= LOTTO_PRICE) { "로또 구입 금액은 ${LOTTO_PRICE}원 이상이어야 합니다." }
        require(amount % LOTTO_PRICE == 0) { "로또 구입 금액은 ${LOTTO_PRICE}원 단위로 입력해주세요." }
    }

    fun getTicketCount(): Int {
        return amount / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
