package lotto.domain

import lotto.enums.Rank
import kotlin.math.floor

class LotteryResult private constructor(
    private val winningLotto: Lotto,
    private val userLottos: List<Lotto> = listOf(),
    private val rankRecord: List<Record> = listOf(),
) {
    var rate: Double = 0.0
    val records = rankRecord

    fun makeRankResult(amount: Int): LotteryResult {
        calculateRecords()
        calculateRateOfReturn(amount)
        return this
    }

    private fun calculateRecords() {
        userLottos.forEach { lotto ->
            calculateRecordByLotto(lotto)
        }
    }

    private fun calculateRecordByLotto(lotto: Lotto) {
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

        fun of(
            winningLotto: Lotto,
            userLottos: List<Lotto>,
        ): LotteryResult {
            return LotteryResult(
                winningLotto,
                userLottos,
                Rank.records()
            )
        }
    }
}
