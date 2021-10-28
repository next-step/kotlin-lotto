package lotto.domain

import lotto.service.LottoNumberPackagesGenerator

class LottoTicket(val lottoPackages: List<LottoNumberPackage>) {
    companion object {
        fun from(purchaseCount: LottoPurchaseCount, packagesGenerator: LottoNumberPackagesGenerator): LottoTicket {
            return LottoTicket(packagesGenerator.generate(purchaseCount))
        }
    }
}
