package lotto.domain.dto

import lotto.domain.Lotto
import lotto.domain.LottoSeller
import lotto.domain.LottoSeller.Companion.rewardPriceMap
import lotto.domain.WinningLotto

data class LottoMatchResult(val winningLotto: WinningLotto, val lottoList: List<Lotto>) {
    private val matchingMap: Map<Int, Int> = lottoList
        .map { it.match(winningLotto) }
        .groupingBy { it.size }
        .eachCount()

    fun countBy(matchingCount: Int): Int {
        return matchingMap.getOrDefault(matchingCount, 0)
    }

    fun rateOfReturn(): String {
        val totalPrice = LottoSeller.LOTTO_PRICE * lottoList.size
        return String.format("%.2f", revenue().toDouble() / totalPrice.toDouble())
    }

    private fun revenue(): Long {
        return matchingMap
            .entries
            .sumOf { (matchingCount, count) -> rewardPrice(matchingCount) * count }
    }

    private fun rewardPrice(matchingCount: Int): Long {
        return rewardPriceMap.getOrDefault(matchingCount, 0)
    }
}
