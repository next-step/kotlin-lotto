package lotto.domain

import lotto.model.Lotto
import lotto.model.Lotto.Companion.NUMBER_OF_LOTTO_DIGIT
import lotto.model.LottoNumber

class LottoGenerator {

    fun generate(): Lotto =
        LOTTO_NUMBER_STORAGE.shuffled()
            .take(NUMBER_OF_LOTTO_DIGIT)
            .map(::LottoNumber)
            .toList()
            .sortedBy { it.value }
            .let(::Lotto)

    companion object {
        private val LOTTO_NUMBER_STORAGE = (1..45).map { it }.toSet()
    }
}
