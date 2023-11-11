package lotto.business

data class ProfitRate(val value: Double) {
    fun evaluateProfitOrLoss(): Boolean {
        return value > BASE
    }

    companion object {
        private const val BASE = 1.0
    }
}
