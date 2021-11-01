package lotto.domain

class Result(matchHistories: List<Int>) {
    val values: Map<Int, Int>

    init {
        val map = mutableMapOf(3 to 0, 4 to 0, 5 to 0, 6 to 0)
        matchHistories.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        this.values = map
    }

    fun calculateProfit(money: Money): Double = values.map { prizeMoney[it.key]?.times(it.value) ?: 0 }
        .reduce { acc, i -> acc + i } / money.value.toDouble()

    companion object {
        @JvmStatic
        val prizeMoney = mapOf(3 to 5000, 4 to 50000, 5 to 1500000, 6 to 2000000000)
    }
}
