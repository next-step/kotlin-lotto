package lotto.domain

class Money(val value: Int) {
    init {
        validateMoneyIsPositiveZero(value)
    }

    private fun validateMoneyIsPositiveZero(money: Int) {
        require(money >= 0) { "돈은 0보다 커야 합니다." }
    }
}
