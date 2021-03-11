package lotto.dto

import lotto.domain.Lotto

fun List<Lotto>.toLottoNumbersDto() = LottoNumbersDto(this.map { it.lottoNumbers.map { it.value } })

data class LottoNumbersDto(val lottos: List<List<Int>>) {
    val count = lottos.size
}
