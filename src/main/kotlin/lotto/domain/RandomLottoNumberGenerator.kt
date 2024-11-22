package lotto.domain

import lotto.domain.Lotto.Companion.MAXIMUM_NUMBER
import lotto.domain.Lotto.Companion.MINIMUM_NUMBER
import lotto.domain.Lotto.Companion.NUMBER_OF_NUMBER

class RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun getLottoNumbers(): List<Int> {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled().subList(0, NUMBER_OF_NUMBER).sorted()
    }
}
