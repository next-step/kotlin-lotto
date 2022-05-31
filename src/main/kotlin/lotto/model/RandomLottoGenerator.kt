package lotto.model

import lotto.model.Lotto.Companion.LOTTO_NUMBER_COUNT

object RandomLottoGenerator {
    fun generate() = LottoNumber.LOTTO_NUMBERS.shuffled()
        .subList(0, LOTTO_NUMBER_COUNT)
        .sortedBy { it.number }
}
