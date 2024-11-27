package lotto.domain

import lotto.domain.Lotto.Companion.MAXIMUM_NUMBER
import lotto.domain.Lotto.Companion.MINIMUM_NUMBER
import lotto.domain.Lotto.Companion.NUMBER_OF_NUMBER

class RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun getLottoNumbers(): LottoNumbers {
        return LottoNumbers((MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled().subList(0, NUMBER_OF_NUMBER).map { LottoNumber(it) }.toSet())
    }
}
