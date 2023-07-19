package lottogame.domain.generator

import lottogame.domain.lotto.Lotto

fun interface LottoGenerator {

    fun get(): Lotto
}
