package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber

class AutoLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        val lottoNumbers = (LottoNumber.MINIMUM_LOTTO_NUMBER..LottoNumber.MAXIMUM_LOTTO_NUMBER).map {
            LottoNumber.from(it)
        }.shuffled().take(Lotto.LOTTO_NUMBERS_SIZE)

        return Lotto.from(lottoNumbers)
    }
}
