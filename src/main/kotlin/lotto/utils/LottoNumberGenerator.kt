package lotto.utils

import lotto.domain.LottoNumber
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_END_BOUND
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_START_BOUND

object LottoNumberGenerator {

    fun auto(): Set<LottoNumber> {
        return (LOTTO_NUMBER_START_BOUND..LOTTO_NUMBER_END_BOUND).toList()
            .shuffled()
            .take(6)
            .sorted()
            .map { LottoNumber(it) }
            .toSet()
    }
}
