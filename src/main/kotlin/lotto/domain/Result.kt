package lotto.domain

data class Result(val elements: Map<Rank, Int>) {

    fun calculateYield(purchase: Money): Yield {
        val totalPrize = elements.map { it.key.prizeMoney * it.value }
            .reduce { acc, money -> acc + money }
        return Yield(totalPrize / purchase)
    }
}
