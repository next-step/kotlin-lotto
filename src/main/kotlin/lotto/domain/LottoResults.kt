package lotto.domain

import java.math.BigDecimal

@JvmInline
value class LottoResults private constructor(private val lottoResults: List<LottoResult>) {

    fun getResults(): List<LottoResult> = lottoResults.toList()

    fun sumPrize(): BigDecimal = lottoResults.sumOf {
        val (lottoPrize, count) = it.prizeAndCountPair()
        lottoPrize.prize * count
    }.toBigDecimal()

    fun sumLottoCount(): BigDecimal =
        (lottoResults.sumOf { it.getMatchingCount() } * Lotto.PRICE).toBigDecimal()

    companion object {
        fun matchingWinningNumber(
            winningLottoNumbers: LottoNumbers,
            bonusLottoNumber: LottoNumber,
            purchasedLottos: Lottos
        ): LottoResults {
            val matchingWinningNumbers: List<MatchingWinningNumber> =
                purchasedLottos.toMatchingWinningNumbers(winningLottoNumbers, bonusLottoNumber)

            val lottoResults = LottoPrize.getPrizes().map {
                LottoResult.decideLottoPrize(it, matchingWinningNumbers)
            }
            return LottoResults(lottoResults)
        }
    }
}
