package lotto.business

data class ProfitRate(val value: Double) {
    fun evaluateProfitOrLoss(): String {
        return if (value > BASE) PROFIT else LOSS
    }

    companion object {
        private const val BASE = 1.0
        private const val PROFIT = "이익"
        private const val LOSS = "손해"
    }
}
