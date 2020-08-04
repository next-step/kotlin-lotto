package lotto.domain

import lotto.LOTTO_PRICE

class Results(results: List<Result>) {
    var matchResults= mutableListOf(0, 0, 0, 0)
        private set

    init {
        results.filterNot { it == Result.ELSE }
            .forEach { matchResults[it.MatchResultsIndex]++ }
    }

    private fun totalProfitRatio(): Double {
        var income = 0.0
        for (x in matchResults.indices) {
            income += prizes[x] * matchResults[x]
        }
        return convertToDouble(income)
    }

    private fun convertToDouble(income: Double) =
        String.format("%.2f", income / payment).toDouble()

    override fun toString(): String {
        val totalResults = StringBuilder()

        appendResultsDetail(totalResults)
        appendProfitRatio(totalResults)

        return totalResults.toString()
    }

    private fun appendResultsDetail(totalResults: StringBuilder) {
        for (x in matchResults.indices) {
            totalResults.append("${conditions[x]}개 일치 (${prizes[x]}원)- ${matchResults[x]}개\n")
        }
    }

    private fun appendProfitRatio(totalResults: StringBuilder) {
        totalResults.append("총 수익률은 ${totalProfitRatio()}입니다. (기준이 1이기 때문에 결과적으로 ")
        if (totalProfitRatio() < 1) totalResults.append("손해라는 의미임)")
        else totalResults.append("이득이라는 의미임)")
    }

    companion object {
        private const val FOURTH_PRIZE = 5000
        private const val THIRD_PRIZE = 50000
        private const val SECOND_PRIZE = 1_500_000
        private const val FIRST_PRIZE = 2_000_000_000

        private val conditions = listOf(3, 4, 5, 6)
        private val prizes = listOf(FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE)

        var payment: Int = LOTTO_PRICE
    }
}
