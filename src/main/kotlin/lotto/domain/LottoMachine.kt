package lotto.domain

import kotlin.math.roundToInt

class LottoMachine(
    private val money: LottoMoney,
    private val lottoNumbersGenerator: LottoNumbersGenerator
) {
    private val lottos: Lottos = Lottos(buyLotto(money))

    fun getLottoResult(winningLotto: WinningLotto): LottoResult {
        return LottoResult(getLottoRanks(winningLotto), calculateEarningRate(winningLotto))
    }

    private fun getLottoRanks(winningLotto: WinningLotto): Map<LottoRank, Int> {
        return lottos.getLottoRanks(winningLotto)
    }

    fun getTotalCount(): Int {
        return lottos.getTotalCount()
    }

    fun getLottos(): List<Lotto> {
        return lottos.lottos
    }

    private fun calculateEarningRate(winningLotto: WinningLotto): Double {
        return getLottoRanks(winningLotto).map { it.key.prize * it.value }.sum().toDouble()
            .div(money.value.toDouble())
            .times(100)
            .roundToInt()
            .div(100.0)
    }

    private fun buyLotto(money: LottoMoney): List<Lotto> {
        return LottoBuyer(lottoNumbersGenerator).buyLotto(money)
    }

    data class LottoResult(
        val lottoRanks: Map<LottoRank, Int>,
        val earningRate: Double
    )
}
