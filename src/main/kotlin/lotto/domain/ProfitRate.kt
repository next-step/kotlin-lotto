package lotto.domain

@JvmInline
value class ProfitRate(private val value: Double) {

    val isProfit: Boolean
        get() = value > THRESHOLD

    companion object {
        private const val THRESHOLD = 1
    }

    override fun toString(): String = value.toString()
}
