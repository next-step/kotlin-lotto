package lotto

import lotto.enums.LottoReturn

class LottoResult private constructor(
    private val lottos: List<Lotto>,
    private val lastWeekResultLotto: ResultLotto,
    private val lottoReturns: MutableList<LottoReturn>,
) {
    private val totalReturnPrice: Int
        get() = lottoReturns.sumOf { it.returnPrice }

    private val totalInputPrice: Int
        get() = lottos.size * LottoPrice.PRICE_PER_LOTTO

    val returnRatio: Double
        get() = totalReturnPrice.toDouble() / totalInputPrice

    fun count(lottoReturn: LottoReturn): Int {
        return lottoReturns.count { it == lottoReturn }
    }

    private fun calculate() {
        lottoReturns.addAll(lottos.toLottoReturns())
    }

    private fun List<Lotto>.toLottoReturns(): List<LottoReturn> {
        return this.map { lastWeekResultLotto.decideReturn(it) }
    }

    companion object {
        fun from(lottos: List<Lotto>, lastWeekResultLotto: ResultLotto): LottoResult {
            return LottoResult(
                lottos = lottos,
                lastWeekResultLotto = lastWeekResultLotto,
                lottoReturns = mutableListOf(),
            ).apply {
                this.calculate()
            }
        }
    }
}
