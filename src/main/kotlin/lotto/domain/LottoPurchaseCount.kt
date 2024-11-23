package lotto.domain

class LottoPurchaseCount(private val pay: Int) {
    val amount: Int

    init {
        require(pay >= PRICE_PER_LOTTO) { PAY_MIN_EXCEPTION }
        amount = pay / PRICE_PER_LOTTO
    }

    companion object {
        private const val PAY_MIN_EXCEPTION = "최소 구매 금액이 1000원 이상이어야 합니다."
        const val PRICE_PER_LOTTO = 1000
    }
}
