package com.nextstep.lotto.domain

class Lottos(val lottos: List<Lotto>) {

    fun match(winningLotto: WinningLotto): Map<Int, Int> {
        val matchCounts = lottos.map { winningLotto.match(it) }
        return countsToMap(matchCounts)
    }

    private fun countsToMap(matchCounts: List<Int>): Map<Int, Int> {
        val matchCountsToCounts = mutableMapOf<Int, Int>()
        matchCounts.forEach { matchCountsToCounts[it] = matchCountsToCounts.getOrDefault(it, 0) + 1 }
        return matchCountsToCounts
    }

    fun getCount(): Int = lottos.size
}
