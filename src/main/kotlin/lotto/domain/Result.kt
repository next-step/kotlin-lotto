package lotto.domain

class Result(matchHistories: List<MatchingCount>) {
    val values: Map<Rank, Int> = matchHistories.groupingBy { Rank.valueOf(it) }
        .eachCount()
        .toMutableMap()
        .also(this::setZeroIfNotExist)

    private fun setZeroIfNotExist(map: MutableMap<Rank, Int>) {
        Rank.values().forEach { rank -> map[rank] = map[rank] ?: ZERO }
    }

    fun calculateProfit(money: Money): Double = values.map { (rank, matchCount) -> rank.winningMoney * matchCount }
        .reduce { acc, i -> acc + i } / money.value.toDouble()

    companion object {
        private const val ZERO = 0
    }
}
