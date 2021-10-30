package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class LottoResult(
    private val lottoPackages: List<LottoNumberPackage>,
    private val winningInfo: WinningInfo,
    private val purchaseAmount: LottoPurchaseAmount
) {
    val resultStatistics: Map<LottoResultRank, Int> = buildResultStatistics(lottoPackages, winningInfo)
    val profitRate: BigDecimal = buildTotalProfitRate(lottoPackages, winningInfo, purchaseAmount)

    private fun buildResultStatistics(lottoPackages: List<LottoNumberPackage>, winningInfo: WinningInfo): Map<LottoResultRank, Int> {
        return lottoPackages
            .groupingBy { LottoResultRank.getRank(it.getRankKey(winningInfo)) }
            .eachCount()
    }

    private fun buildTotalProfitRate(
        lottoPackages: List<LottoNumberPackage>,
        winningInfo: WinningInfo,
        purchaseAmount: LottoPurchaseAmount
    ): BigDecimal {
        return lottoPackages
            .sumOf { it.getPrizeMoney(winningInfo) }
            .toBigDecimal()
            .setScale(2, RoundingMode.HALF_UP)
            .div(purchaseAmount.value!!.toBigDecimal())
    }
}
