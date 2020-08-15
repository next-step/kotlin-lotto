package lotto.model.generator

import lotto.model.lotto.Lotto
import lotto.model.lotto.LottoNumber
import lotto.model.lotto.Numbers

object RandomNumberGenerator {
    private val lottoBallPool = (Lotto.LOTTO_RANGE).map { LottoNumber.from(it) }

    fun generate() = Numbers(getRandomNumber())

    private fun getRandomNumber() = lottoBallPool.shuffled().take(Lotto.NUMBER_COUNT).toSet()
}
