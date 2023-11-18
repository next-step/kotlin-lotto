package lotto.model.strategy

import lotto.model.LottoNumber
import kotlin.random.Random

class LottoNumberRandomWithExceptStrategy(
    private val exceptValues: Set<Int>
) : LottoNumberStrategy {

    private val random = Random(System.currentTimeMillis())

    override fun pick(): Int {
        return generateSequence { random.nextInt(LottoNumber.LOWER_LIMIT_VALUE, LottoNumber.UPPER_LIMIT_VALUE) }
            .filterNot { it in exceptValues }
            .first()
    }
}
