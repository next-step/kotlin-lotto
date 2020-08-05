package service

import model.Lotto

class MatchService(private val prize: List<Int>, private val lottoList: List<Lotto>) {
    val prizeList = getPrizeMap().toSortedMap().toList()

    private fun getPrizeMap(): MutableMap<Int, Int> {
        val prizeMap = mutableMapOf<Int, Int>()
        for (lotto in lottoList) {
            addMap(lotto, prizeMap)
        }
        return prizeMap
    }

    private fun addMap(lotto: Lotto, prizeMap: MutableMap<Int, Int>) {
        val count = lotto.matchCount(prize)
        prizeMap[count] = (prizeMap[count] ?: 0) + 1
    }
}
