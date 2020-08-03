package lotto.domain

import lotto.LOTTO_PRICE

class Results(results: List<Result>) {
    var matchAmounts = mutableListOf(0, 0, 0, 0)
        private set

    init {
        results.filterNot { it == Result.ELSE }
            .forEach { matchAmounts[it.prizeIndex]++ }
    }

    private fun totalProfitRate(): Double {
        var totalIncome = 0.0
        for (x in matchAmounts.indices) {
            totalIncome += prize[x] * matchAmounts[x]
        }
        return convertToDouble(totalIncome)
    }

    private fun convertToDouble(totalIncome: Double) =
        String.format("%.2f", totalIncome / totalPayment).toDouble()

    override fun toString(): String {
        val totalResults = StringBuilder()

        appendResultDetails(totalResults)
        appendProfitRate(totalResults)

        return totalResults.toString()
    }

    private fun appendResultDetails(totalResults: StringBuilder) {
        for (x in matchAmounts.indices) {
            totalResults.append("${conditions[x]}개 일치 ")
            totalResults.append("(${prize[x]}원)- ")
            totalResults.append("${matchAmounts[x]}개")
            totalResults.append("\r\n")
        }
    }

    private fun appendProfitRate(totalResults: StringBuilder) {
        totalResults.append("총 수익률은 ${totalProfitRate()}입니다. ")
        totalResults.append("(기준이 1이기 때문에 결과적으로 ")
        if (totalProfitRate() < 1) totalResults.append("손해라는 의미임)")
        else totalResults.append("이득이라는 의미임)")
    }

    companion object {
        private const val FOURTH_PRIZE = 5000
        private const val THIRD_PRIZE = 50000
        private const val SECOND_PRIZE = 1500000
        private const val FIRST_PRIZE = 2000000000

        private val conditions = listOf(3, 4, 5, 6)
        private val prize = listOf(
            FOURTH_PRIZE,
            THIRD_PRIZE,
            SECOND_PRIZE,
            FIRST_PRIZE
        )

        var totalPayment: Int = LOTTO_PRICE
    }
}
