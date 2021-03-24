package lotto.view.input

data class AmountInput(private val amount: Int) {
    var lottoCount: Int = DEFAULT_LOTTO_COUNT
        private set
    init {
        require(amount >= PER_LOTTO_PRICE) { "최소 금액은 $PER_LOTTO_PRICE 이상 이어야 합니다." }

        lottoCount = amount / PER_LOTTO_PRICE
    }

    constructor(lottoCount: String) : this(lottoCount.toInt())

    companion object {
        private const val PER_LOTTO_PRICE = 1000
        private const val DEFAULT_LOTTO_COUNT = 0

        private fun String.toInt(): Int {
            return this.toIntOrNull() ?: throw IllegalArgumentException("금액은 숫자야여 합니다.")
        }
    }
}
