package domain.store

import domain.lotto.LottoNumbers

interface LottoNumberGenerator {
    fun generate(): LottoNumbers
}
