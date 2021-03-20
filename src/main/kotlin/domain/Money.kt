package domain

data class Money(val value: Int) {
    init {
        require(value >= 0)
    }
}
