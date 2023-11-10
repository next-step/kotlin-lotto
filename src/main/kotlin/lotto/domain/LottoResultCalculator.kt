package lotto.domain

import kotlin.math.floor

class LottoResultCalculator(private val winningLotto: WinningLotto) {

    fun calculateResult(manualLottos: Lottos, autoLottos: Lottos): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()
        for (lotto in manualLottos.lottos + autoLottos.lottos) {
            val rank = winningLotto.calculateRank(lotto)
            val lottoCount = result.getOrDefault(rank, 0)
            result.putIfAbsent(rank, lottoCount + 1)
        }
        return result
    }

    fun calculateEarningRate(result: Map<Rank, Int>, amount: Amount): Double {
        val rate = result.map { result.getOrDefault(it.key, 0) * it.key.winningMoney }
            .sumOf { it.toDouble() }
            .div(amount.amount)
        return floor(rate * 100) / 100
    }
}
