package lotto.stretagy

import lotto.constant.MAXIMUM_NUMBER
import lotto.constant.MINIMUM_NUMBER
import lotto.constant.NUMBER_OF_SELECT

class RandomLottoNumberListGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled()
            .take(NUMBER_OF_SELECT)
            .sorted()
    }
}
