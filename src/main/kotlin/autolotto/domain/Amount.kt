package autolotto.domain

class Amount(val amount: Int) {
    init {
        require(amount > PURCHASE_AMOUNT_NONE_MATCH) { "금액은 0보다 커야합니다." }
        require(amount >= LOTTO_AMOUNT && amount % LOTTO_AMOUNT == PURCHASE_AMOUNT_NONE_MATCH) { "돈은 ${LOTTO_AMOUNT}원 단위로만 입력 가능합니다." }
    }

    fun getLottoGameCount(): Int {
        return amount / LOTTO_AMOUNT
    }

    companion object {
        private const val PURCHASE_AMOUNT_NONE_MATCH = 0
        private const val LOTTO_AMOUNT = 1000
    }
}
