package lotto.domain

data class Money(val amount: Int) {
    init {
        require(amount >= 0) {
            "money cannot be negative"
        }
    }
}
