package lotto.model.generator

import lotto.model.lotto.Lotto
import lotto.model.lotto.Numbers
import lotto.model.lotto.toLottoNumber

object RandomNumberGenerator : LottoNumberGenerator {
    override fun generate() =
        Numbers(getRandomNumber().map(Int::toLottoNumber))

    private fun getRandomNumber() =
        (Lotto.MIN_NUMBER..Lotto.MAX_NUMBER).shuffled().take(Lotto.NUMBER_COUNT)
}
