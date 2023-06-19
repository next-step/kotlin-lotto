package lotto.domain

data class Payment(
    val money: Int
) {
    init {
        validateNegative()
    }

    private fun validateNegative() {
        require(money > MIN_PAYMENT) {
            IllegalArgumentException("구입 금액은 0원 이상이여야 합니다.")
        }
    }

    companion object {
        private const val MIN_PAYMENT = 0
    }
}
