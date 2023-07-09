package lotto.domain.generator

import lotto.domain.Lotto

fun interface LottoGenerator {

    fun get(): Lotto
}
