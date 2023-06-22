package next.step.lotto.view

import next.step.lotto.domain.LottoNumber

object LottoNumberParser {

    fun parse(str: String): Set<LottoNumber> = str.split(",")
        .map { LottoNumber.of(it.trim().toInt()) }
        .toSet()
}