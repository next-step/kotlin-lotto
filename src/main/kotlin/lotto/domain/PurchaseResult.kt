package lotto.domain

class PurchaseResult(amountPaid: String) {

    var numberOfGames: Int = 0
        private set
    var change: Int = 0
        private set

    init {
        require(isNumber(amountPaid)) { "숫자가 아닌 문자가 들어왔습니다." }
        require(amountPaid.toInt() >= LOTTO_PRICE) { "최소 주문 금액보다 적습니다." }
        numberOfGames = amountPaid.toInt() / LOTTO_PRICE
        change = amountPaid.toInt() % LOTTO_PRICE
    }

    private fun isNumber(str: String) =
        str.chars().allMatch(Character::isDigit)


    companion object {
        const val LOTTO_PRICE = 1000
    }
}
