package lotto.domain

@JvmInline
value class Budget private constructor(private val value: Int) {
    init {
        require(value >= LOTTO_PRICE) { throw IllegalArgumentException(MINIMUM_VALUE_REQUIRED) }
    }

    fun getLottoCount(): Int {
        return value / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val MINIMUM_VALUE_REQUIRED = "최소 로또 금액이 되어야합니다."

        fun valueOf(value: Int): Budget {
            return Budget(value)
        }
    }
}
