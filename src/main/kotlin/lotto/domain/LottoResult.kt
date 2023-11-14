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

    fun getLottoResult(): LottoResultData {
        val lottoRanks = lottos.getLottoRanks(winningLotto)
        return LottoResultData(lottoRanks, calculateEarningRate(lottoRanks))
    }

    data class LottoResultData(
        val lottoRanks: Map<LottoRank, Int>,
        val earningRate: Double
    )
}
