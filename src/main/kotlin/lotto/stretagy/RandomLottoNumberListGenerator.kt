package lotto.stretagy

import lotto.constant.MAXIMUM_NUMBER
import lotto.constant.MINIMUM_NUMBER
import lotto.constant.NUMBER_OF_SELECT
import lotto.domain.LottoNumber

class RandomLottoNumberListGenerator : LottoNumberListGenerator {
    override fun generate(): Set<LottoNumber> {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled()
            .take(NUMBER_OF_SELECT)
            .sorted()
            .map(::LottoNumber)
            .toSet()
    }
}
