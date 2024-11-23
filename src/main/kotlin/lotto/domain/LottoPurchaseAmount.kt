package lotto.domain

@JvmInline
value class LottoPurchaseAmount(val amount: Int) {
    constructor(amount: String) : this(amount.toInt())

    init {
        checkIsNaturalNumber()
        checkIsMultiplesOfLottoPrice()
    }

    private fun checkIsNaturalNumber() {
        require(amount > 0) { "로또 구매 금액은 자연수 여야 합니다." }
    }

    private fun checkIsMultiplesOfLottoPrice() {
        require(amount % LOTTO_PRICE == 0) { "로또 구매 금액은 1000원 단위여야 합니다." }
    }

    fun toLottoPurchaseCount(): LottoPurchaseCount {
        return LottoPurchaseCount(this.amount / LOTTO_PRICE)
    }

    companion object {
        private const val LOTTO_PRICE = 1000

        fun fromLottoPurchaseCount(lottoPurchaseCount: LottoPurchaseCount): LottoPurchaseAmount {
            return LottoPurchaseAmount(lottoPurchaseCount.count * LOTTO_PRICE)
        }
    }
}
