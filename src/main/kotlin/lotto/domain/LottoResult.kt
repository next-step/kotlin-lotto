package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class LottoResult(
    private val lottoPackages: List<LottoNumberPackage>,
    private val winningInfo: WinningInfo,
    private val purchaseAmount: LottoPurchaseAmount
) {
    val resultStatistics: Map<LottoResultRank, Int> = getResultStatistics(lottoPackages, winningInfo)
    val profitRate: BigDecimal = getTotalProfitRate(lottoPackages, winningInfo, purchaseAmount)

    companion object {
        private fun getResultStatistics(lottoPackages: List<LottoNumberPackage>, winningInfo: WinningInfo): Map<LottoResultRank, Int> {
            return lottoPackages
                .groupingBy { LottoResultRank.getRank(it.getRankKey(winningInfo)) }
                .eachCount()
        }

        private fun getTotalProfitRate(
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
}
