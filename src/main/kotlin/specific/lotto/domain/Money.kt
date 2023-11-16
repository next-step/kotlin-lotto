package specific.lotto.domain

import toIntOrThrow

data class Money private constructor(val principal: Int, private var _remain: Int) {

    constructor(principal: Int) : this(principal, principal)

    constructor(principal: String?) : this(
        principal
            .toIntOrThrow { "'principal' should be convertible to Int" }
            .also { require(it >= 0) {"'principal' must be equal to or greater than 0"} }
    ) {
        require(!principal.isNullOrBlank()) { "'principal' cannot be null or blank" }
    }

    var remain: Int
        get() = _remain
        private set(value) {
            _remain = value
        }


    fun spend(amount: Int) {
        check(remain >= amount) { "not enough money" }
        remain -= amount
    }
}
