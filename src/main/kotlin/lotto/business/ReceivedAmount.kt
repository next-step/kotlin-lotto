package lotto.business

class ReceivedAmount(private val money: Int) {

    init {
        require(money >= LOTTO_PRICE) { "로또 구입 금액은 ${LOTTO_PRICE}원 이상이어야 합니다." }
        require(money % LOTTO_PRICE == 0) { "로또 구입 금액은 ${LOTTO_PRICE}원 단위로 입력해주세요." }
    }

    fun getTicketCount(): Int {
        return money / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
