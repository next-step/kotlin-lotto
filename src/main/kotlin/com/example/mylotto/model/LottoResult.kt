package com.example.mylotto.model

import com.example.mylotto.constant.LottoConstant
import com.example.mylotto.enum.Rank

class LottoResult private constructor(
    val rankCountMap: Map<Rank, Int>,
    val profitRate: Double,
) {
    companion object {
        fun of(ranks: List<Rank>): LottoResult {
            val rankCountMap = ranks.groupingBy { it }.eachCount()
            val totalWinnings = rankCountMap.entries.sumOf { it.key.winningMoney * it.value }
            val profitRate = totalWinnings.toDouble() / ranks.size / LottoConstant.LOTTO_TICKET_PRICE
            return LottoResult(
                rankCountMap = rankCountMap,
                profitRate = profitRate,
            )
        }
    }
}
