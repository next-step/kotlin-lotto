package lotto.generator

import lotto.Lotto

fun interface LottoGenerator {

    fun get(): Lotto
}
