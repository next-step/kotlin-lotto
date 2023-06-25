package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber

@JvmInline
value class ManualNumbers(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == Lotto.NUMBER_COUNT)
    }
}
