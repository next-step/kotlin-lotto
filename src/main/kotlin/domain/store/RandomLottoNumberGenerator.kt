package domain.store

import domain.lotto.LottoNumbers

interface RandomLottoNumberGenerator {
    fun generate(): LottoNumbers
}
