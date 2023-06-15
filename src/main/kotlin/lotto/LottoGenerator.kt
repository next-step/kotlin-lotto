package lotto

class LottoGenerator {
    fun generate(purchaseAmount: Int): Any {
        validate(purchaseAmount)
        return 1
    }

    private fun validate(purchaseAmount: Int) {
        require(purchaseAmount % PURCHASE_AMOUNT_UNIT == 0) { "로또 구매 금액 단위는 1000원입니다." }
        require(purchaseAmount >= MIN_PURCHASE_AMOUNT) { "로또 최소 구매 금액은 1000원입니다. " }
    }

    companion object {
        private const val MIN_PURCHASE_AMOUNT = 1000
        private const val PURCHASE_AMOUNT_UNIT = 1000
    }
}
