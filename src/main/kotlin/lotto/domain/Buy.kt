package lotto.domain

class Buy(val amount: Int, var manualCount: Int) {

    constructor(amount: Int) : this(amount, manualCount = 0)

    fun getCounts(): Int {
        if (manualCount != 0) {
            return amount / LOTTO_PRICE - manualCount
        }
        return amount / LOTTO_PRICE
    }

    init {
        require(amount > 0 && amount % LOTTO_PRICE == 0) {
            "구매금액을 정확히 입력해주세요. 로또 한장 가격은 $LOTTO_PRICE 원입니다."
        }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
