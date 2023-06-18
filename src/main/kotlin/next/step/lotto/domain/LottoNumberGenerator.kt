package next.step.lotto.domain

import kotlin.random.Random

object LottoNumberGenerator {
    fun random(): Set<LottoNumber> {
        val numbers = mutableSetOf<Int>()
        while (numbers.size != Lotto.LOTTO_NUMBER_CNT) {
            numbers.add(Random.nextInt(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER + 1))
        }
        return numbers.map { LottoNumber.of(it) }.toSet()
    }
}