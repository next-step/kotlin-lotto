package lotto.service

import lotto.domain.LottoNumberPackage
import lotto.domain.LottoPurchaseCount

interface LottoNumberPackagesGenerator {
    fun generate(count: LottoPurchaseCount): List<LottoNumberPackage>
}
