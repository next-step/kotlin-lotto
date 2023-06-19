package lotto

import lotto.enums.LottoReturn

class LottoResult private constructor(
    private val defaultLottoNumbers: List<DefaultLottoNumber>,
    private val lastWeekResultLottoNumber: ResultLottoNumber,
    private val lottoReturns: MutableList<LottoReturn>,
) {
    private val totalReturnPrice: Int
        get() = lottoReturns.sumOf { it.returnPrice }

    private val totalInputPrice: Int
        get() = defaultLottoNumbers.size * LottoPrice.PRICE_PER_LOTTO

    val returnRatio: Double
        get() = totalReturnPrice.toDouble() / totalInputPrice

    fun count(lottoReturn: LottoReturn): Int {
        return lottoReturns.count { it == lottoReturn }
    }

    private fun calculate() {
        lottoReturns.addAll(defaultLottoNumbers.toLottoReturns())
    }

    private fun List<DefaultLottoNumber>.toLottoReturns(): List<LottoReturn> {
        return this.map { lastWeekResultLottoNumber.decideReturn(it) }
    }

    companion object {
        fun from(defaultLottoNumbers: List<DefaultLottoNumber>, lastWeekResultLottoNumber: ResultLottoNumber): LottoResult {
            return LottoResult(
                defaultLottoNumbers = defaultLottoNumbers,
                lastWeekResultLottoNumber = lastWeekResultLottoNumber,
                lottoReturns = mutableListOf(),
            ).apply {
                this.calculate()
            }
        }
    }
}
