package lotto.domain

import lotto.service.LottoNumberPackagesGenerator
import java.math.BigDecimal
import java.math.RoundingMode

class LottoTicket (
    private val purchaseInfo: LottoPurchaseInfo,
    val lottoPackages: List<LottoNumberPackage>
) {
    fun getResultStatistics(winningInfo: WinningInfo): Map<LottoResultRank, Int> {
        return lottoPackages
            .groupingBy { it.matchedCount(winningInfo.winningNumberPackage).rank() }
            .eachCount()
    }

    fun getTotalProfitRate(winningInfo: WinningInfo): BigDecimal {
        return lottoPackages
            .sumOf { it.prizeMoney(winningInfo.winningNumberPackage) }
            .toBigDecimal()
            .setScale(2, RoundingMode.HALF_UP)
            .div(purchaseInfo.purchaseAmount.value.toBigDecimal())
    }

    companion object {
        fun from(purchaseInfo: LottoPurchaseInfo, packagesGenerator: LottoNumberPackagesGenerator): LottoTicket {
            return LottoTicket(purchaseInfo, packagesGenerator.generate(purchaseInfo.purchaseCount.value))
        }
    }
}
