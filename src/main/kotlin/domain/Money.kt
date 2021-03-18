package domain

class Money(val value: Int) {
    init {
        require(value > 0)
    }
}
