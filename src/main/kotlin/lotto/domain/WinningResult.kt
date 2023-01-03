package lotto.domain

import kotlin.math.floor

class WinningResult(lottoList: List<Lotto>, winningLotto: WinningLotto) {

    private val winningResult = RANKING.values().map { 0 }.toTypedArray()

    init {
        lottoList.forEach { lotto ->
            val winningNumbers = winningLotto.matchNumbers(lotto)
            val ranking = RANKING.countOf(winningNumbers.size, lotto.contains(winningLotto.bonusNumber))
            winningResult[ranking.ordinal] ++
        }
    }

    fun getWinningResult(ranking: RANKING): Int {
        return winningResult[ranking.ordinal]
    }

    private fun getWinningPrice(): Int {
        return RANKING.values().sumOf { it.winningPrice * winningResult[it.ordinal] }
    }

    fun rateOfReturn(price: Int): Float {
        return floor(getWinningPrice().toFloat() / price.toFloat() * 100) / 100
    }
}
