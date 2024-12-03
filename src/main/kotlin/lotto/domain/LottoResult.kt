package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.Rank
import java.math.BigDecimal

class LottoResult(
    private val winningLotto: Lotto,
    private val bonusLottoNumber: Int,
    myLottoList: List<Lotto>,
) {
    val resultMap: Map<Rank, Int>

    init {
        resultMap = Rank.entries.associateWith { 0 }.toMutableMap()
        myLottoList.forEach { lotto ->
            val matchCount = lotto.countMatchesOf(winningLotto)
            if (matchCount >= MIN_MATCHING_COUNT) {
                val isBonus = matchCount == BONUS_MATCHING_COUNT && lotto.value.contains(bonusLottoNumber)
                val rank = Rank.fromCount(matchCount, isBonus)
                var winCount = resultMap.getOrDefault(rank, 0)
                resultMap[rank] = ++winCount
            }
        }
    }

    fun getTotalProfit(): BigDecimal {
        return resultMap
            .map { it.key.prizeMoney * it.value.toBigDecimal() }
            .fold(BigDecimal.ZERO, BigDecimal::add)
    }

    private fun Lotto.countMatchesOf(lotto: Lotto): Int {
        return this.value.count { lotto.value.contains(it) }
    }

    companion object {
        private const val MIN_MATCHING_COUNT = 3
        private const val BONUS_MATCHING_COUNT = 5
    }
}
