package lotto.domain

import lotto.service.LottoNumberPackagesGenerator
import java.math.BigDecimal
import java.math.RoundingMode

class LottoTicket(val lottoPackages: List<LottoNumberPackage>) {
    fun resultStatistics(winningInfo: WinningInfo): Map<LottoResultRank, Int> {
        return lottoPackages
            .groupingBy { it.matchedCount(winningInfo.winningNumberPackage).rank() }
            .eachCount()
    }

    fun totalProfitRate(winningInfo: WinningInfo, purchaseAmount: LottoPurchaseAmount): BigDecimal {
        return lottoPackages
            .sumOf { it.prizeMoney(winningInfo.winningNumberPackage) }
            .toBigDecimal()
            .setScale(2, RoundingMode.HALF_UP)
            .div(purchaseAmount.value!!.toBigDecimal())
    }

    companion object {
        fun from(purchaseCount: LottoPurchaseCount, packagesGenerator: LottoNumberPackagesGenerator): LottoTicket {
            return LottoTicket(packagesGenerator.generate(purchaseCount))
        }
    }
}
