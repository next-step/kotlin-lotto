package lotto.domain

class Amount(val amount: Int, val manualCount:Int) {

    init {
        require(amount > PURCHASE_AMOUNT_NONE_MATCH) { "금액은 0보다 커야합니다." }
        require(amount >= LOTTO_AMOUNT && amount % LOTTO_AMOUNT == PURCHASE_AMOUNT_NONE_MATCH) { "돈은 ${LOTTO_AMOUNT}원 단위로만 입력 가능합니다." }
        require(manualCount <= totalLottoGameCount) { "수동 게임은 전체 게임 수를 초과할 수 없습니다." }

    }

    private val totalLottoGameCount: Int get() = amount / LOTTO_AMOUNT
    val lottoGameCount: Int get() = (amount / LOTTO_AMOUNT) - manualCount

    companion object {
        private const val PURCHASE_AMOUNT_NONE_MATCH = 0
        private const val LOTTO_AMOUNT = 1000
    }
}
