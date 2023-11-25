package lotto.domain

class Money(val amount: Int) {
    private val LOTTO_PRICE = 1000

    fun getCounts(): Int {
        return amount / LOTTO_PRICE
    }

    init {
        require(amount > 0 && amount % LOTTO_PRICE == 0) {
            "구매금액을 정확히 입력해주세요. 로또 한장 가격은 $LOTTO_PRICE 원입니다."
        }
    }
}
