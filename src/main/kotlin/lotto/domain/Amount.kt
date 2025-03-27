package lotto.domain

class Amount(
    private val value: Int,
) {
    init {
        require(value in MINIMUM_AMOUNT..MAXIMUM_AMOUNT) {
            "Amount value must be between 1,000 and 100,000 KRW"
        }
    }

    companion object {
        private const val MINIMUM_AMOUNT = 1_000
        private const val MAXIMUM_AMOUNT = 100_000
    }
}
