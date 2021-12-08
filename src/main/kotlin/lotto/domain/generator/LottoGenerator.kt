package lotto.domain.generator

import lotto.domain.entity.common.LottoNumber
import lotto.filter.LottoFilter

object LottoGenerator {

    fun generatorWinningLotto(winningLottoNumber: String): List<LottoNumber> = winningLottoNumber
        .split(",")
        .distinct()
        .map { LottoNumber(LottoFilter.verify(it.trim().toInt())) }
        .sortedBy { it.number }
}
