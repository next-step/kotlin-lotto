package lotto.domain.money

@JvmInline
value class PrizeMoney private constructor(
    val value: Int
) {
    init {
        require(MIN_VALUE <= value) {
            IllegalArgumentException(ERR_INVALID_PRIZE_MONEY_VALUE)
        }
    }

    companion object {
        private const val MIN_VALUE: Int = 0
        const val ERR_INVALID_PRIZE_MONEY_VALUE = "[ERROR] The given value must be equal to $MIN_VALUE or greater than $MIN_VALUE"

        const val FIRST_PLACE_PRIZE: Int = 2_000_000_000
        const val THIRD_PLACE_PRIZE: Int = 1_500_000
        const val FOURTH_PLACE_PRIZE: Int = 50_000
        const val FIFTH_PLACE_PRIZE: Int = 5_000
        const val LAST_PLACE_PRIZE: Int = 0

        val firstPlacePrize: PrizeMoney = PrizeMoney(FIRST_PLACE_PRIZE)
        val thirdPlacePrize: PrizeMoney = PrizeMoney(THIRD_PLACE_PRIZE)
        val fourthPlacePrize: PrizeMoney = PrizeMoney(FOURTH_PLACE_PRIZE)
        val fifthPlacePrize: PrizeMoney = PrizeMoney(FIFTH_PLACE_PRIZE)
        val lastPlacePrize: PrizeMoney = PrizeMoney(LAST_PLACE_PRIZE)
    }
}
