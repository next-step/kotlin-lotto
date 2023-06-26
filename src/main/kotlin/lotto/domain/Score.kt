package lotto.domain

data class Score(val score: List<Rank>) {
    fun calculateRateOfReturn(money: Int): Float {
        val revenue = score.sumOf { it.reward }
        return revenue.toFloat() / money
    }
}
