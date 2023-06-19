package lotto

import lotto.enums.LottoReturn

class LottoResult private constructor(
    private val lottoNumbers: List<LottoNumber>,
    private val lastWeekLottoNumber: LottoNumber,
    private val lottoReturns: MutableList<LottoReturn>,
) {
    private val totalReturnPrice: Int
        get() = lottoReturns.sumOf { it.returnPrice }

    private val totalInputPrice: Int
        get() = lottoNumbers.size * LottoPrice.PRICE_PER_LOTTO

    val returnRatio: Double
        get() = totalReturnPrice.toDouble() / totalInputPrice

    fun count(lottoReturn: LottoReturn): Int {
        return lottoReturns.count { it == lottoReturn }
    }

    private fun calculate() {
        lottoReturns.addAll(lottoNumbers.toLottoReturns())
    }

    private fun List<LottoNumber>.toLottoReturns(): List<LottoReturn> {
        return this.map { it.matchCount(lastWeekLottoNumber) }
    }

    companion object {
        fun from(lottoNumbers: List<LottoNumber>, lastWeekLottoNumber: LottoNumber): LottoResult {
            return LottoResult(
                lottoNumbers = lottoNumbers,
                lastWeekLottoNumber = lastWeekLottoNumber,
                lottoReturns = mutableListOf(),
            ).apply {
                this.calculate()
            }
        }
    }
}
