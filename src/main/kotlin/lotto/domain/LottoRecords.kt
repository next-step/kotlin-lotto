package lotto.domain

import lotto.enums.Rank
import kotlin.math.floor

class LottoRecords(
    private val lottoRecords: Set<LottoRecord>
) {
    fun calculateRecords(recordsByRank: List<Rank>): Set<LottoRecord> {
        lottoRecords.forEach { lottoRecord ->
            addQuantityByRank(recordsByRank, lottoRecord)
        }
        return lottoRecords
    }

    private fun addQuantityByRank(
        recordsByRank: List<Rank>,
        lottoRecord: LottoRecord
    ) {
        if (recordsByRank.contains(lottoRecord.rank)) {
            lottoRecord.addQuantity()
        }
    }

    fun calculateRateOfReturn(amount: Int): Double {
        val sumTotalReward = lottoRecords.sumOf {
            it.totalReward()
        }.toDouble()
        return floor(sumTotalReward / amount * 100.0) / 100.0
    }

    companion object {

        fun fromRank(): LottoRecords {
            val lottoRecords = mutableSetOf<LottoRecord>()
            Rank.values().forEach {
                lottoRecords.add(LottoRecord(it))
            }
            return LottoRecords(lottoRecords)
        }
    }
}