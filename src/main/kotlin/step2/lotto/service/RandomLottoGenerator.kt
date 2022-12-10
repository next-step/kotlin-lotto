package step2.lotto.service

import step2.lotto.service.LottoGenerator.Companion.GENERATE_NUMBER_COUNT
import step2.lotto.service.LottoGenerator.Companion.RANGE_END
import step2.lotto.service.LottoGenerator.Companion.RANGE_START

class RandomLottoGenerator : LottoGenerator {
    override fun generate(): List<Int> =
        List(GENERATE_NUMBER_COUNT) {
            (RANGE_START..RANGE_END).random()
        }
}
