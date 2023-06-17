package step2

import step2.enums.LottoReturn

class LottoResult private constructor(
    private val lottoNumbers: List<LottoNumber>,
    private val lastWeekLottoNumber: LottoNumber,
    private var lottoReturns: List<LottoReturn>,
) {
    private val totalReturnPrice: Int
        get() = lottoReturns.sumOf { it.returnPrice }

    private val totalInputPrice: Int
        get() = lottoNumbers.size * LottoPrice.PRICE_PER_LOTTO

    val returnRatio: Double
        get() = totalReturnPrice.toDouble() / totalInputPrice

    val firstCount: Int
        get() = lottoReturns
            .count { it == LottoReturn.FIRST }

    val secondCount: Int
        get() = lottoReturns
            .count { it == LottoReturn.SECOND }

    val thirdCount: Int
        get() = lottoReturns
            .count { it == LottoReturn.THIRD }

    val fourthCount: Int
        get() = lottoReturns
            .count { it == LottoReturn.FOURTH }

    private fun calculate() {
        lottoReturns = lottoNumbers
            .map { it.matchCount(lastWeekLottoNumber) }
            .map { LottoReturn.from(it) }
    }

    companion object {
        fun from(lottoNumbers: List<LottoNumber>, lastWeekLottoNumber: LottoNumber): LottoResult {
            return LottoResult(
                lottoNumbers = lottoNumbers,
                lastWeekLottoNumber = lastWeekLottoNumber,
                lottoReturns = emptyList(),
            ).apply {
                this.calculate()
            }
        }
    }
}
