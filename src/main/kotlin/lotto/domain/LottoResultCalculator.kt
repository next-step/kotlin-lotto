package lotto.domain

import kotlin.math.floor

class LottoResultCalculator(private val winningLotto: WinningLotto) {

    fun calculateResult(manualLottos: Lottos, autoLottos: Lottos): Map<Rank, Int> {
        return (manualLottos.lottos + autoLottos.lottos)
            .map { winningLotto.calculateRank(it) }
            .groupingBy { it }
            .eachCount()
    }

    fun calculateEarningRate(result: Map<Rank, Int>, amount: Amount): Double {
        val rate = result.map { result.getOrDefault(it.key, 0) * it.key.winningMoney }
            .sumOf { it.toDouble() }
            .div(amount.amount)
        return floor(rate * 100) / 100
    }
}
