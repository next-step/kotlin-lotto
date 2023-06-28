package lotto.dto

import lotto.domain.PrizeLevel

class LottoMatchResult(val matchLottoResult: Map<PrizeLevel, Int>) {

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
