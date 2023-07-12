package lotto.domain.generator

import lotto.domain.TypeLotto

fun interface LottoGenerator {

    fun get(): TypeLotto
}
