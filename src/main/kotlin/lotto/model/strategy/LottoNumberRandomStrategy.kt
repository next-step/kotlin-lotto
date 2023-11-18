package lotto.model.strategy

import lotto.model.LottoNumber.Companion.LOWER_LIMIT_VALUE
import lotto.model.LottoNumber.Companion.UPPER_LIMIT_VALUE
import kotlin.random.Random

object LottoNumberRandomStrategy : LottoNumberStrategy {
    private val random = Random(System.currentTimeMillis())

    override fun pick(): Int {
        return random.nextInt(LOWER_LIMIT_VALUE, UPPER_LIMIT_VALUE)
    }
}
