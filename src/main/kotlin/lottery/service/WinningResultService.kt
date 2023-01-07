package lottery.service

import lottery.domain.lotto.Lotto
import lottery.domain.ranking.Ranking
import lottery.domain.winningresult.WinningResult

class WinningResultService {
    fun draw(lottos: List<Lotto>, winningNumbers: List<Int>): WinningResult {
        val result = prepareResult()

        lottos.forEach { lotto ->
            val numberOfWins = lotto.numbers.filter { winningNumbers.contains(it) }.size
            result[numberOfWins] = result[numberOfWins]?.plus(1) ?: return@forEach
        }

        return result
    }

    private fun prepareResult(): MutableMap<Int, Int> {
        val result = mutableMapOf<Int, Int>()
        Ranking.values().forEach { result[it.rank] = 0 }

        return result
    }

}