package specific.lotto.domain

class Money(val principal: Long) {

    init {
        require(principal >= Ticket.PRICE) { "'principal' must be equal to or greater than ${Ticket.PRICE}" }
    }

    var remaining: Long = principal
        private set

    fun spend(amount: Long) {
        require(amount >= 0) { "amount must be equal to or greater than 0" }
        check(remaining >= amount) { "not enough money" }
        remaining -= amount
    }

    fun make(amount: Long) {
        require(amount >= 0) { "amount must be equal to or greater than 0" }
        remaining += amount
    }

    fun calculateReturnOnInvestment(): Double = remaining.toDouble() / principal

}
