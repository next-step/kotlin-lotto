package lotto.domain

import lotto.enums.Winner

class LottoStatistics(
    val lotto: List<Lotto>
) {

    fun calculate(lastWinningNumber: List<Int>): MutableMap<Winner, Int> {
        val rankMap: MutableMap<Winner, Int> = mutableMapOf(
            Winner.FOURTH_PLACE to 0,
            Winner.THIRD_PLACE to 0,
            Winner.SECOND_PLACE to 0,
            Winner.FIRST_PLACE to 0
        )
        lotto.forEach {
            val matchCount = getMatchCount(it, lastWinningNumber)
            val find = Winner.values().find { winner ->
                winner.matchCount == matchCount
            }?.let { winner -> rankMap.put(winner,rankMap.getOrDefault(winner, 0) + 1) }
        }
        return rankMap
    }

    fun getMatchCount(lotto: Lotto, lastWinningNumber: List<Int>): Int {
        return lotto.lottoNumbers.count { it in lastWinningNumber }
    }

    fun getRating(purchasePrice: Int, resultMap: Map<Winner, Int>): Double {
        val filterMap = resultMap.filter { it.value >= 1 }
        return (filterMap.keys.sumOf { it.reward } / purchasePrice).toDouble()
    }
}
