package lotto.domain

import kotlin.math.roundToInt

class LottoResult (
    private val money: LottoMoney,
    private val lottos: Lottos,
    private val winningLotto: WinningLotto
){

    private fun calculateEarningRate(lottoRanks: Map<LottoRank, Int>): Double {
        return lottoRanks.map { it.key.prize * it.value }.sum().toDouble()
            .div(money.value.toDouble())
            .times(100)
            .roundToInt()
            .div(100.0)
    }

    fun getLottoResult(): LottoResult {
        val lottoRanks = lottos.getLottoRanks(winningLotto)
        return LottoResult(lottoRanks, calculateEarningRate(lottoRanks))
    }

    data class LottoResult(
        val lottoRanks: Map<LottoRank, Int>,
        val earningRate: Double
    )
}
