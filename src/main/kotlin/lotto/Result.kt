package lotto

import kotlin.math.round

class Result {
    fun getStatistics(buyTicket: Int, ranks: List<Rank>): Double {
        val totalReward = (ranks.sumBy { it.reward }).toDouble()
        return round(totalReward / (buyTicket * 1000) * 100) / 100
    }
}
