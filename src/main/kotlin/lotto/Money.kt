package lotto

data class Money(val amount: Int) {
    init {
        require(amount >= 0) {
            "money cannot be negative"
        }
    }
}
