package lotto.dto

import lotto.domain.Lotto

fun List<Lotto>.toLottoNumbersDto(manualLottoCount: Int, randomLottoCount: Int) =
    run { LottoNumbersDto(this.map { it.lottoNumbers.map { it.value } }, manualLottoCount, randomLottoCount) }

data class LottoNumbersDto(val lottos: List<List<Int>>, val manualLottoCount: Int, val randomLottoCount: Int)
