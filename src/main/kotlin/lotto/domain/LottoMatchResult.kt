package lotto.domain

import lotto.domain.LottoSeller.Companion.rewardPriceMap
import lotto.domain.enums.LottoRank

class LottoMatchResult(
    private val winningLotto: WinningLotto,
    private val lottoList: List<Lotto>
) {
    val matchingMap: Map<LottoRank, Int> = lottoList
        .map { it.match(winningLotto) }
        .groupingBy { LottoRank.of(it.size) }
        .eachCount()

    val revenue = matchingMap
        .entries
        .sumOf { (matchingCount, count) -> rewardPrice(matchingCount) * count }

    fun matchingCountBy(lottoRank: LottoRank): Int {
        return matchingMap.getOrDefault(lottoRank, 0)
    }

    fun rateOfReturn(): String {
        val totalPrice = LottoSeller.LOTTO_PRICE * lottoList.size
        return String.format("%.2f", revenue.toDouble() / totalPrice.toDouble())
    }

    private fun rewardPrice(lottoRank: LottoRank): Long {
        return rewardPriceMap.getOrDefault(lottoRank.matchingCount, 0)
    }
}
