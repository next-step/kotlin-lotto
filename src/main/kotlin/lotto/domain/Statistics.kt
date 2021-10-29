package lotto.domain

data class Statistics(val countedMatches: Map<Match, Int>) {
    fun calculateRatio(purchasePrice: Int): Double {
        return calculateProfit().toDouble() / purchasePrice
    }

    private fun calculateProfit(): Int {
        return countedMatches.entries
            .sumOf { it.key.prize * it.value }
    }
}
