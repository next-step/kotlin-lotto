package lotto.domain

data class Money(val amount: Int) {
    init {
        require(amount >= 0) {
            NEGATIVE_VALUE_MESSAGE
        }
    }

    companion object {
        private const val NEGATIVE_VALUE_MESSAGE = "화폐는 음수일 수 없습니다."
    }
}
