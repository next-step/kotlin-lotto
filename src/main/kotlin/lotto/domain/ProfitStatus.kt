package lotto.domain

enum class ProfitStatus(val message: String) {
    PROFIT("이익"),
    BREAK_EVEN("본전"),
    LOSS("손해"), ;

    companion object {
        private const val EARNING_RATIO_THRESHOLD = 1.0

        fun of(earningRatio: Double) =
            when {
                earningRatio < EARNING_RATIO_THRESHOLD -> LOSS
                earningRatio == EARNING_RATIO_THRESHOLD -> BREAK_EVEN
                earningRatio > EARNING_RATIO_THRESHOLD -> PROFIT
                else -> throw IllegalArgumentException()
            }
    }
}
