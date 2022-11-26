package lotto.domain

import lotto.domain.LottoConstants.LOTTE_PRICE
import kotlin.math.floor

class LottoStatistics(val matchResult: Map<Rank, Int>) {
    fun getRateOfReward(): Double {
        val amount = getCountOfLotto() * LOTTE_PRICE
        val reward = matchResult.map { it.key.getTotalWinningMoney(it.value) }.sum().toDouble()
        return floor(reward / amount * 100) / 100
    }

    private fun getCountOfLotto(): Int = matchResult.values.sum()
}
