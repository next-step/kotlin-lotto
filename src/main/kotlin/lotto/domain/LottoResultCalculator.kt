package lotto.domain

import kotlin.math.floor

class LottoResultCalculator(private val winningLotto: WinningLotto) {

    fun calculateResult(manualLottos: Lottos, autoLottos: Lottos): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()
        for (lotto in manualLottos.lottos + autoLottos.lottos) {
            val matchCount = winningLotto.matchCount(lotto)
            val matchBonus = lotto.contains(winningLotto.bonusNumber)
            val rank = Rank.from(matchCount, matchBonus)
            val lottoCount = result.getOrDefault(rank, 0)
            result.putIfAbsent(rank, lottoCount + 1)
        }
        return result
    }

    fun calculateEarningRate(result: Map<Rank, Int>, amount: Int): Double {
        val rate = result.map { result.getOrDefault(it.key, 0) * it.key.winningMoney }
            .sumOf { it.toDouble() }
            .div(amount)
        return floor(rate * 100) / 100
    }
}
