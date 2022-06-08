package lotto.controller.dto

import lotto.domain.Lotto

data class LottoData(
    val lottoNumbers: List<Int>,
) {
    companion object {
        fun of(lotto: Lotto) = LottoData(lotto.lottoNumbers.map { it.value })
    }
}
