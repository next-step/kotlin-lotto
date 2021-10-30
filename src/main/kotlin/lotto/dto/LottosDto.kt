package lotto.dto

import lotto.domain.Lottos

@JvmInline
value class LottosDto(val lottos: List<List<Int>>) {
    companion object {
        fun from(lottos: Lottos): LottosDto {
            return LottosDto(lottos.lottos.map { it.numbers.map { it.value } })
        }
    }
}
