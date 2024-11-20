package lotto

@JvmInline
value class LottoPurchaseAmount(private val amount: Int) {
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

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
