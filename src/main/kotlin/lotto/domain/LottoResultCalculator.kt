package lotto.domain

import kotlin.math.floor

class LottoResultCalculator(private val winningNumbers: List<Int>) {

    fun calculateResult(lottos: List<Lotto>): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()
        for (lotto in lottos) {
            val matchCount = winningNumbers.count { lotto.contains(it) }
            val rank = Rank.from(matchCount)
            val lottoCount = result.getOrDefault(rank, 0)
            result.putIfAbsent(rank, lottoCount + 1)
        }
        return result
    }

    fun calculateEarningRate(result: Map<Rank, Int>, amount: Int): Double {
        var earning = 0.0
        earning += result.getOrDefault(Rank.FIFTH, 0) * Rank.FIFTH.winningMoney
        earning += result.getOrDefault(Rank.FOURTH, 0) * Rank.FOURTH.winningMoney
        earning += result.getOrDefault(Rank.THREE, 0) * Rank.THREE.winningMoney
        earning += result.getOrDefault(Rank.FIRST, 0) * Rank.FIRST.winningMoney
        val rate = earning / amount
        return floor(rate * 100) / 100
    }
}
