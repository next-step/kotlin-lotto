package stringaddcalculator.lotto

import kotlin.random.Random
import kotlin.random.asJavaRandom
import kotlin.streams.toList

interface LottoGenerator {
    fun generate(): Lotto
}

object RandomLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        val numbers = Random.asJavaRandom()
            .ints(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE + 1)
            .distinct()
            .limit(Lotto.SIZE_OF_LOTTO_NUMBERS.toLong())
            .mapToObj { LottoNumber(it) }
            .toList()
        return Lotto(numbers)
    }
}
