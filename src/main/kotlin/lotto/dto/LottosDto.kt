package lotto.dto

import lotto.domain.Lottos

data class LottosDto(val manualSize: Int, val autoSize: Int, val lottos: List<List<Int>>) {
    companion object {
        fun from(manualSize: Int, autoSize: Int, lottos: Lottos): LottosDto {
            return LottosDto(manualSize, autoSize, lottos.lottos.map { it.numbers.map { it.value } })
        }
    }
}
