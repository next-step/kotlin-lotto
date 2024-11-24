package lotto.application

import lotto.domain.LottoLine

fun interface LottoLineGenerator {
    fun generate(): LottoLine
}
