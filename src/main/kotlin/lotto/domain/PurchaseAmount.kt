package lotto.domain

class PurchaseAmount(private val value: Int) {
    init {
        require(value % LOTTO_PRICE == 0) { LOTTO_PRICE_UNIT_ERROR_MESSAGE }
    }

    fun getLottoCount() = value / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000

        private const val LOTTO_PRICE_UNIT_ERROR_MESSAGE = "구매 가격이 로또 판매 단위에 맞지 않습니다."
    }
}
