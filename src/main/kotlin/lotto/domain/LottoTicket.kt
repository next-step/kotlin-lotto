package lotto.domain

import lotto.service.LottoNumberPackagesGenerator

class LottoTicket private constructor(
    private val purchaseInfo: LottoPurchaseInfo,
    val lottoPackages: List<LottoNumberPackage>
) {

    companion object {
        fun from(purchaseInfo: LottoPurchaseInfo, packagesGenerator: LottoNumberPackagesGenerator): LottoTicket {
            return LottoTicket(purchaseInfo, packagesGenerator.generate(purchaseInfo.purchaseCount.value))
        }
    }
}
