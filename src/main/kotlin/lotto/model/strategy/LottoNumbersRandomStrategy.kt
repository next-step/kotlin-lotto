package lotto.model.strategy

import lotto.model.LottoGame
import lotto.model.LottoNumber
import lotto.model.LottoNumber.Companion.LOWER_LIMIT_VALUE
import lotto.model.LottoNumber.Companion.UPPER_LIMIT_VALUE

object LottoNumbersRandomStrategy : LottoNumbersStrategy {
    override fun pick(): Set<LottoNumber> {
        return (LOWER_LIMIT_VALUE..UPPER_LIMIT_VALUE)
            .shuffled()
            .take(LottoGame.REQUIRE_COUNT_OF_NUMBER)
            .map { LottoNumber(it) }
            .toSet()
    }
}
