package lotto.domain

@JvmInline
value class Revenue private constructor(val rateOfReturn: Double) {

    constructor(proceeds: Double, purchasedPrice: Double) : this(
        rateOfReturn = when {
            proceeds <= ZERO_RATE || purchasedPrice <= ZERO_RATE -> ZERO_RATE
            else -> proceeds / purchasedPrice
        }
    )

    companion object {
        private const val ZERO_RATE: Double = 0.0
    }
}
