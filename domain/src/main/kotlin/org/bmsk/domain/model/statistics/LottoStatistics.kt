package org.bmsk.domain.model.statistics

data class LottoStatistics(
    val matchCounts: Map<MatchCount, Int>,
    val totalProfitRate: Double,
)
