package lotto.domain

class Money(value: Int) {

    var value = value
        private set

    init {
        require(value >= 0) { "[$value] is less than zero" }
    }

    fun sub(amount: Int) {
        value -= amount
    }
}
