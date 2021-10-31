package lotto.service

import lotto.domain.LottoNumber
import lotto.domain.LottoNumberPackage
import lotto.domain.LottoPurchaseCount

class AutomaticLottoNumberPackagesGenerator : LottoNumberPackagesGenerator {
    override fun generate(count: LottoPurchaseCount): List<LottoNumberPackage> {
        return IntRange(1, count.value)
            .map { getShuffledPackage() }
    }

    private fun getShuffledPackage(): LottoNumberPackage {
        return LottoNumberPackage(LottoNumber.getShuffledLottoNumbers())
    }
}
