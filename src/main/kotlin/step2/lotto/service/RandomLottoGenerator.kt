package step2.lotto.service

import step2.lotto.service.LottoGenerator.Companion.LOTTO_SIZE
import step2.lotto.service.LottoGenerator.Companion.RANGE_END
import step2.lotto.service.LottoGenerator.Companion.RANGE_START

class RandomLottoGenerator : LottoGenerator {
    override fun generate(): MutableSet<Int> {
        val randomNumbers = mutableSetOf<Int>()
        while (randomNumbers.size != LOTTO_SIZE) {
            randomNumbers.add((RANGE_START..RANGE_END).random())
        }
        return randomNumbers
    }
}
