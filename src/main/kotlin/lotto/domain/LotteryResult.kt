package lotto.domain

import kotlin.math.floor

class LotteryResult private constructor(
    val rankRecord: Set<Record>,
) {
    var rate: Double = 0.0

    fun makeRankResult(
        amount: Int,
        matchCounts: List<Int>,
    ) {
        calculateRecords(matchCounts)
        calculateRateOfReturn(amount)
    }

    private fun calculateRecords(matchCounts: List<Int>) {
        rankRecord.forEach { record ->
            matchCounts.filter {
                it == record.matchCount
            }.forEach {
                record.addCountByRecord(it)
            }
        }
    }

    private fun calculateRecordByLotto(lotto: Lotto, winningLotto: Lotto) {
        val matchCount = lotto.makeMatchCountByNumbers(winningLotto)
        rankRecord.forEach {
            it.addCountByRecord(matchCount)
        }
    }

    private fun calculateRateOfReturn(amount: Int) {
        val sumTotalReward = rankRecord.sumOf {
            it.totalReward()
        }.toDouble()
        rate = floor(sumTotalReward / amount * 100.0) / 100.0
    }

    companion object {

        fun from(
            rankRecord: Set<Record>,
        ): LotteryResult {
            return LotteryResult(rankRecord)
        }
    }
}
