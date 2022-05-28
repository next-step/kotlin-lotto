package lotto.domain

class LottoStatistics(private val money: Int, results: Map<Winning, Int>) {
    var totalAmount: Double = 0.0

    init {
        results.forEach { (winning, winningCount) ->
            totalAmount += winning.winningAmount * winningCount
        }
    }

    fun getYield(): Double = totalAmount / money
}
