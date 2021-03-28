package domain.store

import domain.lotto.LottoNumber
import domain.lotto.LottoNumbers

class CommonRandomLottoNumberGenerator : RandomLottoNumberGenerator {
    override fun generate(): LottoNumbers {
        return LottoNumber.VALUES.shuffled()
            .take(LottoNumbers.SIZE)
            .let { LottoNumbers.fromList(it) }
    }
}
