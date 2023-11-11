package lotto.util

import lotto.domain.LottoNumber

object LottoNumberGenerator : NumberGenerator<LottoNumber> {
    override fun generateNumbers(count: Int): List<LottoNumber> {
        return LottoNumber.getLottoNumbers()
            .asSequence()
            .shuffled()
            .take(count)
            .sortedBy { it.value }
            .toList()
    }
}
