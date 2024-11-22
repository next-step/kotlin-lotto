package lotto.domain

import lotto.domain.LottoRule.LOTTO_NUMBER_COUNT
import lotto.domain.LottoRule.LOTTO_NUMBER_MAX
import lotto.domain.LottoRule.LOTTO_NUMBER_MIN

fun interface LottoNumberGenerator {
    fun generate(): Set<Int>
}

class AutoLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): Set<Int> {
        return (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX)
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .toSet()
    }
}
