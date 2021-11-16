package lotto.domain

class Result(matchHistories: List<MatchingCount>) {
    val values: Map<Rank, Int>

    init {
        this.values = matchHistories.fold(mutableMapOf()) { map, matchingCount ->
            map[Rank.valueOf(matchingCount)] = map.getOrDefault(Rank.valueOf(matchingCount), 0) + 1
            map
        }

        Rank.values().forEach { rank ->
            values[rank] = values[rank]?.let { values[rank] } ?: 0
        }
    }

    fun calculateProfit(money: Money): Double = values.map { it.key.winningMoney * it.value }
        .reduce { acc, i -> acc + i } / money.value.toDouble()
}
