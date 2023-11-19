package lottoAuto.domain

enum class LottoProfitMessage(val message: String) {
    PROFIT("이익"),
    BREAK_EVEN("본전"),
    LOSS("손해");

    companion object {
        fun fromRateOfReturn(rateOfReturn: Double): LottoProfitMessage {
            return when {
                rateOfReturn > 1.00 -> PROFIT
                rateOfReturn == 1.00 -> BREAK_EVEN
                else -> LOSS
            }
        }
    }
}

