package lotto.domain.generator

import lotto.domain.entity.common.LottoNumber
import lotto.filter.LottoFilter

object LottoGenerator {

    fun generatorLotto(lottoNumber: String): List<LottoNumber> = lottoNumber
        .split(",")
        .distinct()
        .map { LottoNumber(LottoFilter.verify(it.trim().toInt())) }
        .sortedBy { it.number }
}
