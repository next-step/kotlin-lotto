package lotto.service

import lotto.domain.LottoNumberPackage
import lotto.domain.LottoNumberPool

class AutomaticLottoNumberPackagesGenerator : LottoNumberPackagesGenerator {
    override fun generate(count: Int): List<LottoNumberPackage> {
        return IntRange(1, count)
            .map { getShuffledPackage() }
    }

    private fun getShuffledPackage(): LottoNumberPackage {
        return LottoNumberPackage(LottoNumberPool.getShuffledLottoNumbers())
    }
}
