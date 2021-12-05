package lotto.domain.entity.generator

import lotto.filter.LottoFilter

object LottoGenerator {

    fun generatorWinningLotto(winningLottoNumber: String): List<Int> = winningLottoNumber
        .split(",")
        .map { LottoFilter.verify(it.trim().toInt()) }
        .distinct()
        .sorted()
}
