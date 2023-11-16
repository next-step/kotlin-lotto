package specific.lotto.domain

data class Money private constructor(val principal: Int, private var _remain: Int) {

    constructor(principal: Int) : this(principal, principal)

    init {
        require(principal >= 0) { "'principal' must be equal to or greater than 0" }
    }

    val remain: Int
        get() = _remain

    fun spend(amount: Int) {
        check(remain >= amount) { "not enough money" }
        _remain -= amount
    }
}
