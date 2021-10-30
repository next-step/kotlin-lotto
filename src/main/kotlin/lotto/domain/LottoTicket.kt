package lotto.domain

import lotto.service.LottoNumberPackagesGenerator

class LottoTicket(private val lottoPackages: List<LottoNumberPackage>) {
    fun lottoPackages(): List<LottoNumberPackage> {
        return lottoPackages.toList()
    }

    fun buildResult(winningInfo: WinningInfo, purchaseAmount: LottoPurchaseAmount): LottoResult {
        return LottoResult(lottoPackages(), winningInfo, purchaseAmount)
    }

    companion object {
        fun from(purchaseCount: LottoPurchaseCount, packagesGenerator: LottoNumberPackagesGenerator): LottoTicket {
            return LottoTicket(packagesGenerator.generate(purchaseCount))
        }
    }
}
