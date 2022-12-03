package lotto.domain

data class LottoStatisticsTotal(
    val totalRate: Double,
    val winLottoStatisticsResult: List<LottoStatisticsResult>
)
