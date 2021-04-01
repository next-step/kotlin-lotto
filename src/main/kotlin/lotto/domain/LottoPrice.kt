package lotto.domain

data class LottoPrice(private val input: Int) {
    val price: Int

    init {
        validateUnit(input)
        price = input
    }

    private fun validateUnit(amount: Int) {
        require(amount % LOTTO_PRICE == 0) { "구입할 금액은 천원 단위로 입력할 수 있습니다." }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
