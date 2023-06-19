package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_SIZE
import lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_LOTTO_NUMBER

interface LottoGenerator {
    fun generate(): Lotto
}

class RandomLottoGenerator : LottoGenerator {
    override fun generate(): Lotto = LOTTO_NUMBERS.shuffled().subList(0, LOTTO_SIZE).let { Lotto(it) }

    companion object {
        private val LOTTO_NUMBERS = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).map { LottoNumber(it) }
    }
}
