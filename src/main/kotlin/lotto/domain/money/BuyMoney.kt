package lotto.domain.money

@JvmInline
value class BuyMoney(val value: Int) {
    init {
        assertGivenValueIsValid(value)
    }

    private fun assertGivenValueIsValid(value: Int) {
        require(isGreaterThanZero(value) && isMultipleOfTicketDefaultPrice(value)) {
            IllegalArgumentException(ERR_INVALID_MONEY_VALUE)
        }
    }

    private fun isGreaterThanZero(value: Int): Boolean =
        MIN_VALUE < value

    private fun isMultipleOfTicketDefaultPrice(value: Int): Boolean =
        value % DEFAULT_LOTTO_GAME_PRICE == 0

    val howManyBuyLottoGames: Int
        get() = value / DEFAULT_LOTTO_GAME_PRICE

    companion object {
        const val MIN_VALUE = 0
        const val DEFAULT_LOTTO_GAME_PRICE: Int = 1_000
        const val ERR_INVALID_MONEY_VALUE = "[ERROR] The given value must be greater than $MIN_VALUE and multiple of $DEFAULT_LOTTO_GAME_PRICE"
    }
}
