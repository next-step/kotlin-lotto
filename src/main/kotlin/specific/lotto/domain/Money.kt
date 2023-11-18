package specific.lotto.domain

data class Money private constructor(val principal: Long, private var _remain: Long) {

    constructor(principal: Long) : this(principal, principal)

    init {
        require(principal >= 0) { "'principal' must be equal to or greater than 0" }
    }

    val remain: Long
        get() = _remain

    fun spend(amount: Long) {
        require(amount >= 0) { "amount must be equal to or greater than 0" }
        check(remain >= amount) { "not enough money" }
        _remain -= amount
    }

    fun make(amount: Long) {
        require(amount >= 0) { "amount must be equal to or greater than 0" }
        _remain += amount
    }

    fun calculateReturnOnInvestment(): Double = remain.toDouble() / principal
}
