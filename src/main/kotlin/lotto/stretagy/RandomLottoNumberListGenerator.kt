package lotto.stretagy

import lotto.constant.MAXIMUM_NUMBER
import lotto.constant.MINIMUM_NUMBER

class RandomLottoNumberListGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled()
            .take(NUMBER_OF_SELECT)
            .sorted()
    }

    companion object {
        private const val NUMBER_OF_SELECT = 6
    }
}
