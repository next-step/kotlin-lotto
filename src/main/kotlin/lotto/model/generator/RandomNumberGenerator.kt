package lotto.model.generator

import lotto.model.lotto.Lotto
import lotto.model.lotto.Numbers
import lotto.model.lotto.toLottoNumber

object RandomNumberGenerator : LottoNumberGenerator {
    private val lottoBallPool = (Lotto.LOTTO_RANGE).map(Int::toLottoNumber)

    override fun generate() = Numbers(getRandomNumber())

    private fun getRandomNumber() = lottoBallPool.shuffled().take(Lotto.NUMBER_COUNT).toSet()
}
