package lotto.adapter

import lotto.domain.ProfitRate

data class ProfitRateDto(
    val profitRate: Double,
    val criterion: Double,
) {
    companion object {
        fun from(profitRate: ProfitRate): ProfitRateDto {
            return ProfitRateDto(profitRate.profitRate, profitRate.criterion)
        }
    }
}
