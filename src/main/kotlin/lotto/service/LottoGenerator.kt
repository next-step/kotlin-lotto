package lotto.service

import lotto.model.Lotto
import lotto.model.Lotto.Companion.LOTTO_NUMBER_COUNT
import lotto.model.LottoNumber

object LottoGenerator {
    private const val STRING_DELIMITER = ","

    fun fromString(input: String): Lotto {
        return input.split(STRING_DELIMITER)
            .map { LottoNumber.of(it.trim()) }
            .let { Lotto.of(it) }
    }

    fun getRandomLotto(): Lotto {
        return LottoNumber.getAllNumbers()
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .let { Lotto.of(it) }
    }
}
