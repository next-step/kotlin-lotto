package lotto.view.dto

data class LottoResultsDto(
    val winResults: List<LottoRankDto>,
    val profitRate: Double,
    val isProfit: Boolean,
    val margin: Int,
)
