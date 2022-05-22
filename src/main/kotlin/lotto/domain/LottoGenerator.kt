package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_RANGE

interface LottoGenerator {
    fun generate(): Lotto
}

object RandomLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        val lottoNumbers = LOTTO_NUMBER_RANGE
            .shuffled()
            .take(Lotto.SIZE_OF_LOTTO_NUMBERS)
        return Lotto.of(lottoNumbers)
    }
}
