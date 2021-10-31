package lotto.domain

import lotto.service.LottoNumberPackagesGenerator

class LottoTicket(private val _lottoPackages: List<LottoNumberPackage>) {
    val lottoPackages: List<LottoNumberPackage>
        get() {
            return _lottoPackages.toList()
        }

    fun buildResult(winningInfo: WinningInfo, purchaseAmount: LottoPurchaseAmount): LottoResult {
        return LottoResult(lottoPackages, winningInfo, purchaseAmount)
    }

    companion object {
        fun from(purchaseCount: LottoPurchaseCount, packagesGenerator: LottoNumberPackagesGenerator): LottoTicket {
            return LottoTicket(packagesGenerator.generate(purchaseCount))
        }
    }
}
