package lotto.service

import lotto.domain.LottoNumberPackage
import lotto.domain.LottoNumberPool
import lotto.domain.LottoPurchaseCount

class AutomaticLottoNumberPackagesGenerator : LottoNumberPackagesGenerator {
    override fun generate(count: LottoPurchaseCount): List<LottoNumberPackage> {
        return IntRange(1, count.value)
            .map { getShuffledPackage() }
    }

    private fun getShuffledPackage(): LottoNumberPackage {
        return LottoNumberPackage(LottoNumberPool.getShuffledLottoNumbers())
    }
}
