package lotto.view.input

data class AmountInput(private val amount: Int) {
    val lottoCount: Int

    init {
        require(amount >= PER_LOTTO_PRICE) { "최소 금액은 $PER_LOTTO_PRICE 이상 이어야 합니다." }

        lottoCount = amount / PER_LOTTO_PRICE
    }

    constructor(lottoCount: String) : this(lottoCount.toIntOrNull() ?: throw IllegalArgumentException("금액은 숫자야여 합니다."))

    companion object {
        private const val PER_LOTTO_PRICE = 1000
    }
}
