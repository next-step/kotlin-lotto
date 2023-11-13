package lotto.domain

import kotlin.math.floor

class LotteryResult private constructor(
    val rankRecord: List<Record> = listOf(),
) {
    var rate: Double = 0.0

    fun makeRankResult(
        amount: Int,
        winningLotto: Lotto,
        userLottos: List<Lotto>
    ) {
        calculateRecords(winningLotto, userLottos)
        calculateRateOfReturn(amount)
    }

    private fun calculateRecords(winningLotto: Lotto, userLottos: List<Lotto>) {
        userLottos.forEach { lotto ->
            calculateRecordByLotto(lotto, winningLotto)
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
            rankRecord: List<Record>,
        ): LotteryResult {
            return LotteryResult(rankRecord)
        }
    }
}
