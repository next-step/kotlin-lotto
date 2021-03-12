package lotto.domain

data class Result(val elements: Map<Rank, Int>) {

    fun calculateStatistics(purchase: Money): Statistics {
        val totalPrize = elements.map { it.key.prizeMoney * it.value }
            .reduce { acc, money -> acc + money }
        return Statistics(totalPrize / purchase)
    }
}
