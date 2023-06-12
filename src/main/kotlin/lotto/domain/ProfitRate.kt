package lotto.domain

@JvmInline
value class ProfitRate(val value: Double) {

    val isProfit: Boolean
        get() = value > THRESHOLD

    companion object {
        private const val THRESHOLD = 1
    }
}
