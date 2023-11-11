package lotto.util

import lotto.domain.LottoNumber

object LottoNumberGenerator : NumberGenerator {

    override fun generate(count: Int): List<Int> {
        return LottoNumber.getLottoNumbers()
            .asSequence()
            .shuffled()
            .take(count)
            .sortedBy { it.value }
            .map { it.value }
            .toList()
    }
}
