package lotto

class PurchaseMoney(val money: Int) {

    init {
        require(money > 0) {
            NEGATIVE_VALUE_MESSAGE
        }
    }

    companion object {
        private const val NEGATIVE_VALUE_MESSAGE = "화폐는 음수일 수 없습니다."
    }
}
