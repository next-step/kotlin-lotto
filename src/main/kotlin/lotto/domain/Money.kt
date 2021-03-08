package lotto.domain

data class Money(val value: Int) {
    init {
        require(value >= 0)
    }

    companion object {
        val ZERO = Money(0)
    }
}
