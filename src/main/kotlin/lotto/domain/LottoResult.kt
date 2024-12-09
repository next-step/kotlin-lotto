package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.Rank
import java.math.BigDecimal

class LottoResult(
    private val winningLotto: Lotto,
    private val bonusLottoNumber: LottoNumber,
    myLottoList: List<Lotto>,
) {
    val resultMap: Map<Rank, Int>

    init {
        resultMap = Rank.entries.associateWith { 0 }.toMutableMap()
        myLottoList.forEach { lotto ->
            getRank(lotto)?.let { rank ->
                var rankCount = resultMap.getOrDefault(rank, 0)
                resultMap[rank] = ++rankCount
            }
        }
    }

    private fun getRank(lotto: Lotto): Rank? {
        val matchCount = lotto.countMatchesOf(winningLotto)
        if (matchCount >= MIN_MATCHING_COUNT) {
            val isBonus = lotto.containsAny(bonusLottoNumber)
            return Rank.fromMatchCount(matchCount, isBonus)
        }
        return null
    }

    fun getTotalProfit(): BigDecimal {
        return resultMap
            .map { it.key.prizeMoney * it.value.toBigDecimal() }
            .fold(BigDecimal.ZERO, BigDecimal::add)
    }

    companion object {
        private const val MIN_MATCHING_COUNT = 3
    }
}
