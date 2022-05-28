package lotto.domain

data class Worth(
    val investment: Int,
    val numberOfLotteries: Int
) {
    constructor(investment: Int) : this(investment, numberOfLotteries = investment / ONE_LOTTO_PRICE)

    companion object {
        private const val ONE_LOTTO_PRICE = 1000
    }
}
