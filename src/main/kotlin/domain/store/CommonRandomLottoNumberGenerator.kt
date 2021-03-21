package domain.store

import domain.lotto.LottoNumber
import domain.lotto.LottoNumbers

class CommonRandomLottoNumberGenerator : RandomLottoNumberGenerator {
    override fun generate(): LottoNumbers {
        return NUMBER_RANGE.shuffled()
            .take(LottoNumbers.SIZE)
            .map { LottoNumber(it) }
            .let { LottoNumbers(it) }
    }

    companion object {
        private val NUMBER_RANGE = LottoNumber.MIN..LottoNumber.MAX
    }
}
