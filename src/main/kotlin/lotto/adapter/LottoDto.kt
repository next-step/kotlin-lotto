package lotto.adapter

import lotto.domain.Lotto

data class LottoDto(
    val numbers: List<Int>,
) {
    companion object {
        fun from(lotto: Lotto): LottoDto {
            return LottoDto(lotto.numbers.map { it.number })
        }
    }
}
