package lotto.service

import lotto.model.Lotto
import lotto.model.Lotto.Companion.LOTTO_NUMBER_COUNT
import lotto.model.LottoNumber

object LottoGenerator {
    private const val STRING_DELIMITER = ","

    fun parse(input: String): List<Int> {
        return input.split(STRING_DELIMITER).map { it.trim().toInt() }
    }

    fun fromString(input: String): Lotto {
        return input.split(STRING_DELIMITER)
            .map(LottoNumber::of)
            .let { Lotto.ofList(it) }
    }

    fun getRandomLotto(): Lotto {
        return LottoNumber.getAllNumbers()
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .let { Lotto.ofList(it) }
    }
}
