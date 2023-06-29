package lotto.dto

import lotto.domain.PrizeLevel

class LottoMatchResult(private val matchLottoResult: Map<PrizeLevel, Int>) {

    fun getMatchLottoResult(): Map<PrizeLevel, Int> {
        return matchLottoResult.toMap()
    }

    companion object {
        fun countPrizeLevels(prizeLevels: List<PrizeLevel>): Map<PrizeLevel, Int> {
            return prizeLevels
                .filter { it != PrizeLevel.NONE }
                .groupingBy { it }
                .eachCount()
                .withDefault { 0 }
        }
    }
}
